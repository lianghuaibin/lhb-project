package com.lhb.service.impl;

import com.lhb.common.util.LogUtil;
import com.lhb.common.util.TimeUtil;
import com.lhb.domain.pojo.LhbJoke;
import com.lhb.domain.pojo.LhbRomantic;
import com.lhb.domain.pojo.LhbTodayHistoryEvent;
import com.lhb.service.IWebCrawlingDataService;
import com.lhb.service.LhbJokeService;
import com.lhb.service.LhbRomanticService;
import com.lhb.service.LhbTodayHistoryEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/11/3.
 */
@Service("webCrawlingDataServiceImpl")
public class WebCrawlingDataServiceImpl implements IWebCrawlingDataService {

    @Autowired
    private LhbTodayHistoryEventService lhbTodayHistoryEventService;
    @Autowired
    private LhbRomanticService lhbRomanticService;
    @Autowired
    private LhbJokeService lhbJokeService;

    /**
     * 发起http get请求获取网页源代码
     *
     * @param requestUrl
     * @return
     */
    private String httpRequest(String requestUrl) {
        StringBuffer buffer = null;
        try {
            // 建立连接
            URL url = new URL(requestUrl);
            HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
            httpUrlConn.setDoInput(true);
            httpUrlConn.setRequestMethod("GET");
            // 获取输入流
            InputStream inputStream = httpUrlConn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            // 读取返回结果
            buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            // 释放资源
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            httpUrlConn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }
    /**
     * 从html中抽取出历史上当天的相关信息
     * @param html
     * @return
     *    map{
     *        dateTag
     *        content
     *    }
     */
    private Map<String, String> extract(String html,String dateTag) {
        Map<String, String> map = new HashMap<String, String>();
        StringBuffer buffer = null;
        // 日期标签：区分是昨天还是今天
        Pattern p = Pattern.compile("(.*)(<div class=\"listren\">)(.*?)(</div>)(.*)");
        Matcher m = p.matcher(html);
        if (m.matches()) {
            buffer = new StringBuffer();
            if (m.group(3).contains(getMonthDay(-1))){
                dateTag = getMonthDay(-1);
            }
            // 拼装标题
            buffer.append("≡≡ ").append("历史上的").append(dateTag).append(" ≡≡").append("\n\n");
            // 抽取需要的数据
            for (String info : m.group(3).split("  ")) {
                info = info.replace(dateTag, "").replace("（图）", "").replaceAll("&nbsp;","").replaceAll("</?[^>]+>", "").trim();
                // 在每行末尾追加2个换行符
                if (!"".equals(info)) {
                    buffer.append(info).append("\n\n");
                }
            }
        }
        String content= (null == buffer) ? null : buffer.substring(0, buffer.lastIndexOf("\n\n"));
        map.put("dateTag",dateTag);
        map.put("content",content);
        // 将buffer最后两个换行符移除并返回
        return map;
    }
    /**
     * 从html中抽取出浪漫语句
     * @param html
     * @return
     *    map{
     *        dateTag
     *        content
     *    }
     */
    private List<String> extractRomantic(String html) {
        List<String> list = new ArrayList<String>();
        StringBuffer buffer = new StringBuffer();
        Pattern p = Pattern.compile("(.*)(<div class=\"say_list\">)(.*?)(<div class=\"page_all2\">)(.*)");
        Matcher m = p.matcher(html);
        if (m.matches()) {
            // 抽取需要的数据
            for (String info : m.group(3).split("</dl>")) {
                buffer.setLength(0);
                buffer.append(info.replaceAll("</?[^>]+>", "").trim());
                if(buffer.toString().length()>20){
                    String content =buffer.toString().split("        ")[1].trim()
                            .split("                        ")[0].trim();
                    if(content.length()>5){
                        list.add(content);
                    }
                }
            }
        }
        return list;
    }

    /**
     * 获取前/后n天日期(M月d日)
     *
     * @return
     */
    private String getMonthDay(int diff) {
        DateFormat df = new SimpleDateFormat("M月d日");
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_YEAR, diff);
        return df.format(c.getTime());
    }

    @Override
    public int insertHistoryData() {
        int ret=0;
        StringBuilder sql =new StringBuilder();
        try {
            for(int m=1;m<=12;m++){
                int monthSum=TimeUtil.getAmountOfMonthByDate(TimeUtil.getYear(new Date())+"-"+m);
                for(int d=1;d<= monthSum;d++){
                    sql.setLength(0);
                    sql.append("INSERT INTO lhb_today_history_event(id,dateTag,content) VALUES(null,?,?)");
                    // 获取网页源代码
                    String html = httpRequest("http://www.rijiben.com/dashiji/"+m+"-"+d+"/");
                    // 从网页中抽取信息
                    Map<String, String> map = extract(html, m + "月" + d + "日");
                    LhbTodayHistoryEvent lhbTodayHistoryEvent = new LhbTodayHistoryEvent();
                    lhbTodayHistoryEvent.setDatetag(map.get("dateTag"));
                    lhbTodayHistoryEvent.setContent(map.get("content"));
                    lhbTodayHistoryEventService.insert(lhbTodayHistoryEvent);
                }
            }
        } catch (Exception e){
            LogUtil.error("爬取历史数据异常");
            LogUtil.error(e);
        }
        LogUtil.paramAndResult("-insertHistoryData-", "历史数据插入完成" , "game over！");
        return ret;
    }

    @Override
    public int insertRomanticData() {
        int ret=0;
        try {
            for(int i=1;i<=10;i++){
                String html = httpRequest("http://mingyan.jokeji.cn/juzi/langman/list_" + i + ".html");
                List<String> list = extractRomantic(html);
                for(int j=0;j<list.size();j++){
                    LhbRomantic lhbRomantic = new LhbRomantic();
                    lhbRomantic.setContent(list.get(j));
                    lhbRomanticService.insert(lhbRomantic);
                }
            }
        } catch (Exception e){
            LogUtil.error("爬取浪漫话语数据异常");
            LogUtil.error(e);
        }
        LogUtil.paramAndResult("-insertHistoryData-", "浪漫话语数据插入完成" , "game over！");
        return ret;
    }

    @Override
    public int insertJokeData() {
        int ret=0;
        try {
            for(int i=1;i<=12;i++){
                String html = httpRequest("http://mingyan.jokeji.cn/juzi/gaoxiao/list_" + i + ".html");
                List<String> list = extractRomantic(html);
                for(int j=0;j<list.size();j++){
                    LhbJoke lhbJoke = new LhbJoke();
                    lhbJoke.setContent(list.get(j));
                    lhbJokeService.insert(lhbJoke);
                }
            }
        } catch (Exception e){
            LogUtil.error("爬取开心一刻数据异常");
            LogUtil.error(e);
        }
        LogUtil.paramAndResult("-insertHistoryData-", "开心一刻数据插入完成" , "game over！");
        return ret;
    }

    /**
     * 通过main在本地测试
     *
     * @param args
     */
    public static void main(String[] args) {
        // 获取网页源代码
        WebCrawlingDataServiceImpl wcdsi=new WebCrawlingDataServiceImpl();
        String html = wcdsi.httpRequest("http://mingyan.jokeji.cn/juzi/gaoxiao/list_1.html");
        List<String> list = wcdsi.extractRomantic(html);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
