package com.lhb.web.thread;


import com.lhb.service.IWebCrawlingDataService;

/**
 * Created by Administrator on 2015/11/3.
 */
public class InsertDataThread implements Runnable {
    private Integer sign;
    private IWebCrawlingDataService todayInHistoryService;
    public InsertDataThread(Integer sign,IWebCrawlingDataService todayInHistoryService){
        this.sign=sign;
        this.todayInHistoryService=todayInHistoryService;
    }

    @Override
    public void run() {

//        IWebCrawlingDataService todayInHistoryService = (IWebCrawlingDataService) SpringContext.getBean("webCrawlingDataServiceImpl");
        if(sign==1){//插入历史今天的数据
            todayInHistoryService.insertHistoryData();
        }else if (sign==2){//浪漫话语
            todayInHistoryService.insertRomanticData();
        }else if (sign==3){//开心笑话
            todayInHistoryService.insertJokeData();
        }
    }
}
