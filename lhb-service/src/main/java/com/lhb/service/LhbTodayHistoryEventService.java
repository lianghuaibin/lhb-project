/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.service;

import com.lhb.domain.query.LhbTodayHistoryEventQuery;
import com.lhb.domain.pojo.LhbTodayHistoryEvent;
import java.util.List;

/**
* 历史今天表Service层接口
*
* @author lianghuaibin
* @since 2016/05/05
*/
public interface LhbTodayHistoryEventService {

    /**
    * 插入
    * @param lhbTodayHistoryEvent
    * @return 新增记录ID
    */
    int insert(LhbTodayHistoryEvent lhbTodayHistoryEvent);

    /**
    * 更新
    * @param lhbTodayHistoryEvent
    * @return 更新影响数据条数
    */
    int update(LhbTodayHistoryEvent lhbTodayHistoryEvent);

    /**
    * 根据ID查询
    * @param id
    * @return
    */
    LhbTodayHistoryEvent findById(Long id);

    /**
    * 查询
    * @param lhbTodayHistoryEvent
    * @return
    */
    List<LhbTodayHistoryEvent> find(LhbTodayHistoryEventQuery lhbTodayHistoryEvent);
}