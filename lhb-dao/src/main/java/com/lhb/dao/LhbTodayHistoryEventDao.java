/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.dao;

import com.lhb.domain.pojo.LhbTodayHistoryEvent;
import com.lhb.domain.query.LhbTodayHistoryEventQuery;
import java.util.List;

/**
* 历史今天表DAO层接口
*
* @author lianghuaibin
* @since 2016/05/05
*/
public interface LhbTodayHistoryEventDao {

    /**
    * 插入
    * @param lhbTodayHistoryEvent
    */
    int insert(LhbTodayHistoryEvent lhbTodayHistoryEvent);

    /**
    * 更新
    * @param lhbTodayHistoryEvent
    */
    int update(LhbTodayHistoryEvent lhbTodayHistoryEvent);

    /**
    * 根据ID查询
    * @param id
    */
    LhbTodayHistoryEvent findById(Long id);

    /**
    * 查询
    * @param lhbTodayHistoryEvent
    */
    List<LhbTodayHistoryEvent> find(LhbTodayHistoryEventQuery lhbTodayHistoryEvent);
}