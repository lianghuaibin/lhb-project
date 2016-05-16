package com.lhb.wechat.service;

import com.alibaba.fastjson.JSONObject;
import com.lhb.wechat.message.resp.Article;
import com.lhb.wechat.message.resp.NewsMessage;
import com.lhb.wechat.message.resp.TextMessage;
import com.lhb.wechat.util.MessageUtil;
import com.lhb.common.util.StringUtil;
import com.lhb.common.util.TimeUtil;
import com.lhb.wechat.util.TuringRobot;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/11/3.
 */
@Service
public class MessageService {


        /**
         * 处理微信发来的请求
         *
         * @param request
         * @return
         *    requestMap{
         *         ToUserName
         *         FromUserName
         *         respMessage  返回内容
         *         inputInt    返回数字
         *    }
         */
        public Map<String, String> processRequest(HttpServletRequest request) {
            String respMessage;
            Map<String, String> requestMap = null;
            try {
                // 默认返回的文本消息内容
                String respContent = "请求处理异常，请稍候尝试！";

                // xml请求解析
                requestMap = MessageUtil.getInstance().parseXml(request);

                // 发送方帐号（open_id）
                String fromUserName = requestMap.get("FromUserName");
                // 公众帐号
                String toUserName = requestMap.get("ToUserName");
                // 消息类型
                String msgType = requestMap.get("MsgType");

                // 回复文本消息
                TextMessage textMessage = new TextMessage();
                textMessage.setToUserName(fromUserName);
                textMessage.setFromUserName(toUserName);
                textMessage.setCreateTime(new Date().getTime());
                textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);

                // 文本消息
                if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {
                    respContent = "您发送的是文本消息！";
                    String content = requestMap.get("Content");
                    if(StringUtil.isNum(content)){
                        requestMap.put("inputInt",content);
                    }else if(StringUtil.isQqFace(content)) {
                        // 回复文本消息
                        // 用户发什么QQ表情，就返回什么QQ表情
                        respContent = content;
                    }
                }
                // 图片消息
                else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                    respContent = "您发送的是图片消息！"+StringUtil.emoji(0x2600);
                }
                // 地理位置消息
                else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                    respContent = "您发送的是地理位置消息！";
                }
                // 链接消息
                else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                    respContent = "您发送的是链接消息！";
                }
                // 音频消息
                else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                    respContent = "您发送的是音频消息！";
                }
                // 事件推送
                else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                    // 事件类型
                    String eventType = requestMap.get("Event");
                    // 订阅
                    if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                        respContent = subscribeText();
                    }
                    // 取消订阅
                    else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                        // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                    }
                    // 自定义菜单点击事件
                    else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                        // TODO 自定义菜单权没有开放，暂不处理该类消息
                    }
                }

                textMessage.setContent(respContent);
                respMessage = MessageUtil.getInstance().textMessageToXml(textMessage);

                requestMap.put("respMessage",respMessage);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return requestMap;
        }

    /**
     * 获取文本信息
     * @param map{
     *           FromUserName
     *           ToUserName
     *           respMessage
     *           }
     * @return
     */
    public String getTextPushMsg(Map<String,String> map){
        TextMessage msg = new TextMessage();
        msg.setToUserName(map.get("FromUserName"));
        msg.setFromUserName(map.get("ToUserName"));
        msg.setCreateTime(new Date().getTime());
        msg.setMsgType("text");
        msg.setContent(map.get("respMessage"));
        String message=MessageUtil.getInstance().textMessageToXml(msg);
        return message;
    }
    /**
     * 获取图文返回消息(只返回一条)
     * @param map{
     *          ToUserName
     *          FromUserName
     *           title     (Articles为null时，需要)
     *           picUrl    (Articles为null时，需要)
     *           content   (Articles为null时，需要)
     *           skipUrl   (Articles为null时，需要)
     *            }
     *         Articles 【List<Article>】
     * @return
     */
    public String getNewsPushMsg(Map<String, String> map,List<Article> Articles) {

        if(Articles == null || Articles.size()<1){
            Articles =new ArrayList<Article>();
            Article article =new Article();
            article.setTitle(map.get("title").toString());
            article.setPicUrl(map.get("picUrl").toString());
            article.setDescription(map.get("content").toString());
            article.setUrl(map.get("skipUrl").toString());
            Articles.add(article);
        }
        NewsMessage nMsg=new NewsMessage();
        nMsg.setFromUserName(map.get("ToUserName"));
        nMsg.setToUserName(map.get("FromUserName"));
        nMsg.setCreateTime(TimeUtil.getCurrentTimeStamp());
        nMsg.setMsgType("news");
        nMsg.setArticleCount(Articles.size());
        nMsg.setArticles(Articles);

        return MessageUtil.getInstance().newsMessageToXml(nMsg);
    }

    /**
     * 调用机器人
     * @param requestMap
     * @return
     */
    public String callRobot(Map<String, String> requestMap){
        String url="http://www.tuling123.com/openapi/api?info="+requestMap.get("Content");
        String respMessage = new TuringRobot().httpRequest(url);
        JSONObject json = JSONObject.parseObject(respMessage);
        String message = getRobotReply(requestMap, json);
        return message;
    }

    /**
     * 机器人回复
     * @param map
     * @param json
     * @return
     */
    public String getRobotReply(Map<String, String> map,JSONObject json){
        Integer code = json.getInteger("code");
        String message;
        if(code==100000){//文字类
            map.put("respMessage", json.get("text").toString());
            message = getTextPushMsg(map);
        }else if(code==200000){//图片链接类
            /*map.put("title", json.get("text").toString());
            map.put("picUrl", json.get("url").toString());
            map.put("content", "点击进入查看吧~！");
            map.put("skipUrl", json.get("url").toString());
            message = getNewsPushMsg(map,null);*/
            map.put("respMessage", "<a href=\""+json.get("url").toString()+"\">"+json.get("text").toString()+"</a>");
            message = getTextPushMsg(map);
        }else if(code==308000){//菜谱
            List<Article> Articles =new ArrayList<Article>();
            List<Map<String,String>> list = (List<Map<String, String>>) json.get("list");
            for(Map<String,String> one : list){
                if(Articles.size()>=10){
                    break;
                }
                Article article =new Article();
                article.setTitle(one.get("name"));
                article.setPicUrl(one.get("icon"));
                article.setDescription(one.get("info"));
                article.setUrl(one.get("detailurl"));
                Articles.add(article);

            }
            message = getNewsPushMsg(map,Articles);
        }else{//其他未处理标识码
            map.put("respMessage", "服务器正在升级");
            message = getTextPushMsg(map);
        }

        return message;
    }

    /**
     * 关注后，推送消息
     * @return
     */
    public static String subscribeText(){
        StringBuffer content=new StringBuffer();
        content.append("欢迎您的关注，我们将竭诚为您服务\n\n")
                .append("1、本人信息\ue001\n")
                .append("2、历史今天\ue419\n")
                .append("3、吐槽专区\ue052\n")
                .append("4、开心一刻\ue056\n")
                .append("5、浪漫话语\ue032\n")
                .append("6、查看菜单\ue148\n")
                .append("其他：机器人自动回复\ue12b\n")
                .append("");
        return content.toString();
    }
}
