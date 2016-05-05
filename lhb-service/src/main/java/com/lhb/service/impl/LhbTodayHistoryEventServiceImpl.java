/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.service.impl;

import com.lhb.dao.LhbTodayHistoryEventDao;
import com.lhb.domain.pojo.LhbTodayHistoryEvent;
import com.lhb.domain.query.LhbTodayHistoryEventQuery;
import com.lhb.service.LhbTodayHistoryEventService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* 历史今天表Service层实现
*
* @author lianghuaibin
* @since 2016/05/05
*/
@Service("lhbTodayHistoryEventService")
public class LhbTodayHistoryEventServiceImpl implements LhbTodayHistoryEventService {

    private static Log log = LogFactory.getLog(LhbTodayHistoryEventServiceImpl.class);

    @Resource
    private LhbTodayHistoryEventDao lhbTodayHistoryEventDao;

    /**
    * 插入
    * @param lhbTodayHistoryEvent
    */
    @Override
    public int insert(LhbTodayHistoryEvent lhbTodayHistoryEvent) {
        log.debug("insert---执行");
        return lhbTodayHistoryEventDao.insert(lhbTodayHistoryEvent);
    }

    /**
    * 更新
    * @param lhbTodayHistoryEvent
    */
    @Override
    public int update(LhbTodayHistoryEvent lhbTodayHistoryEvent) {
        log.debug("update---执行");
        return this.lhbTodayHistoryEventDao.update(lhbTodayHistoryEvent);
    }

    /**
    * 根据ID查询
    * @param id
    */
    @Override
    public LhbTodayHistoryEvent findById(Long id) {
        log.debug("findById---执行");
        return this.lhbTodayHistoryEventDao.findById(id);
    }

    /**
    * 查询
    * @param lhbTodayHistoryEvent
    */
    @Override
    public List<LhbTodayHistoryEvent> find(LhbTodayHistoryEventQuery lhbTodayHistoryEvent) {
    log.debug("find---执行");
    return this.lhbTodayHistoryEventDao.find(lhbTodayHistoryEvent);
    }
}