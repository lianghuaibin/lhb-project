package com.lhb.wechat.controller;

import com.alibaba.fastjson.JSONObject;
import com.lhb.common.util.LogUtil;
import com.lhb.domain.pojo.LhbRespMessage;
import com.lhb.domain.pojo.LhbTodayHistoryEvent;
import com.lhb.domain.query.LhbTodayHistoryEventQuery;
import com.lhb.service.LhbJokeService;
import com.lhb.service.LhbRespMessageService;
import com.lhb.service.LhbRomanticService;
import com.lhb.service.LhbTodayHistoryEventService;
import com.lhb.wechat.service.MessageService;
import com.lhb.wechat.util.MessageUtil;
import com.lhb.wechat.util.StringDomain;
import com.lhb.wechat.util.TimeUtil;
import com.lhb.wechat.util.WcUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author lianghuaibin
 * @since 2016/5/5
 */
@Controller
public class WcController {

    @Autowired
    private StringDomain stringDomain;
    @Autowired
    private MessageService messageService;
    @Autowired
    private LhbTodayHistoryEventService lhbTodayHistoryEventService;
    @Autowired
    private LhbRespMessageService lhbRespMessageService;
    @Autowired
    private LhbJokeService lhbJokeService;
    @Autowired
    private LhbRomanticService lhbRomanticService;

    @RequestMapping(value="weChat.wc", method= RequestMethod.GET)
    public void weChat(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        JSONObject json=new JSONObject();
        String token="";
        try{
            String signature = req.getParameter("signature");
            String timestamp = req.getParameter("timestamp");
            String nonce = req.getParameter("nonce");
            String echostr = req.getParameter("echostr");
            json.put("signature", signature);
            json.put("timestamp", timestamp);
            json.put("nonce", nonce);
            json.put("echostr", echostr);
            if(WcUtil.checkSignature(signature, timestamp, nonce, "wxlhb0802")){
                resp.getWriter().print(echostr);
            }else {
                LogUtil.paramAndResult("-微信token验证失败-", "token：" + token, json.toString());
            }
        } catch(Exception e){
            LogUtil.error(e);
        }
        LogUtil.paramAndResult("--URL-GET-end-", "token:"+token, json.toString());
    }
    @RequestMapping(value="weChat.wc", method=RequestMethod.POST)
    public void rxMsg(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        Map<String,String> requestMap = null;
        String message = "";
        try{

            requestMap = messageService.processRequest(req);
            Integer inputInt=(requestMap.get("inputInt")==null || requestMap.get("inputInt").equals(""))?
                    0:Integer.parseInt(requestMap.get("inputInt"));
            if(inputInt!=0){
                /**
                 * inputInt
                 * 1：个人信息
                 * 2：历史今天
                 * 3：吐槽专区
                 * 4：开心一刻
                 * 5：浪漫花语
                 * 6：查看菜单
                 * 其他：调用机器人
                 */
                switch (inputInt){
                    case 1:
                        LhbRespMessage message1 = lhbRespMessageService.findById(2L);
                        requestMap.put("title",message1.getMsgTitle());
                        requestMap.put("picUrl",stringDomain.getServiceLink(message1.getMsgPic()));
                        requestMap.put("content",message1.getMsgContent());
                        requestMap.put("skipUrl",stringDomain.getServiceLink(message1.getSkipUrl()));
                        message = messageService.getNewsPushMsg(requestMap,null);
                        break;
                    case 2:
                        String dateTag= TimeUtil.getDateStr(new Date(), "M月d日");
                        LhbTodayHistoryEventQuery query = new LhbTodayHistoryEventQuery();
                        query.setDatetag(dateTag);
                        List<LhbTodayHistoryEvent> list = lhbTodayHistoryEventService.find(query);
                        requestMap.put("respMessage",list.get(0).getContent());
                        message = messageService.getTextPushMsg(requestMap);
                        break;
                    case 3:
                        requestMap.put("respMessage","想吐槽我，想的美~\uE052");
                        message = messageService.getTextPushMsg(requestMap);
                        break;
                    case 4:
                        requestMap.put("respMessage", "\uE412" + lhbJokeService.findByRandom().getContent());
                        message = messageService.getTextPushMsg(requestMap);
                        break;
                    case 5:
                        requestMap.put("respMessage",lhbRomanticService.findByRandom().getContent());
                        message = messageService.getTextPushMsg(requestMap);
                        break;
                    case 6:
                        requestMap.put("respMessage",MessageService.subscribeText());
                        message = messageService.getTextPushMsg(requestMap);
                        break;
                    default:
                        message = messageService.callRobot(requestMap);
                        break;
                }
            }else{
                String msgType = requestMap.get("MsgType");
                if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                    String eventType = requestMap.get("Event");// 事件类型
                    if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {// 订阅
                        message = requestMap.get("respMessage");
                    }
                    else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {// 取消订阅
                        // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                    }
                    else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {// 自定义菜单点击事件
                        // TODO 自定义菜单权没有开放，暂不处理该类消息
                    }
                }else{
                    message = messageService.callRobot(requestMap);
                }
            }
            resp.getWriter().print(message);
        } catch(Exception e){
            LogUtil.error("微信回复信息异常");
            LogUtil.error(e);
        }
        LogUtil.paramAndResult("-URL-POST-end", requestMap==null?"":requestMap.toString(),message);
    }






}
