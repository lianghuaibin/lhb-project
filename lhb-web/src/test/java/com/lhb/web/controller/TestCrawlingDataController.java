package com.lhb.web.controller;

import com.lhb.BaseTest;
import com.lhb.service.IWebCrawlingDataService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author lianghuaibin
 * @since 2016/5/16
 */
public class TestCrawlingDataController extends BaseTest {


    @Autowired
    private IWebCrawlingDataService webCrawlingDataService;

    @Test
    public void testInsertJokeData(){
        webCrawlingDataService.insertJokeData();
    }

}
