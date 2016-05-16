package com.lhb.web.controller;

import com.lhb.common.util.LogUtil;
import com.lhb.service.IWebCrawlingDataService;
import com.lhb.web.thread.InsertDataThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lianghuaibin
 * @since 2016/5/16
 */
@Controller
@RequestMapping("crawling")
public class CrawlingDataController {

    @Autowired
    IWebCrawlingDataService todayInHistoryService;
    /**
     * 网络爬取，数据插入数据库
     * @param sign 1：历史上的今天 2：浪漫话语 3:开心一刻
     * @return
     */
    @RequestMapping("insertNetworkData.do")
    public String insertNetworkData(Integer sign){
        try{
            InsertDataThread idt=new InsertDataThread(sign,todayInHistoryService);
            Thread thread = new Thread(idt);
            thread.start();
            LogUtil.paramAndResult("-insertHistoryData-", "插入历史数据:" + sign, "nothing");
        }catch (Exception e){
            LogUtil.error(e);
        }
        return "../index.jsp";

    }
}
