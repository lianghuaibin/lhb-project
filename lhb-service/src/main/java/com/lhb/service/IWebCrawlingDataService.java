package com.lhb.service;

/**
 * Created by Administrator on 2015/11/3.
 */
public interface IWebCrawlingDataService {

    /**
     *  爬取出全部历史数据，并插入数据库
     * @return
     */
    public int insertHistoryData();

    /**
     *  爬取网络浪漫语句，并插入数据库
     * @return
     */
    public int insertRomanticData();

    /**
     * 爬取开心笑话，并插入数据库
     * @return
     */
    public int insertJokeData();


}
