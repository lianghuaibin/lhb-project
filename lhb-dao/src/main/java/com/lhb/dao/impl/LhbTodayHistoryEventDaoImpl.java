/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.dao.impl;

import com.lhb.dao.LhbTodayHistoryEventDao;
import com.lhb.domain.pojo.LhbTodayHistoryEvent;
import com.lhb.domain.query.LhbTodayHistoryEventQuery;

import com.lhb.dao.base.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* 历史今天表DAO层实现
*
* @author lianghuaibin
* @since 2016/05/05
*/
@Repository("lhbTodayHistoryEventDao")
public class LhbTodayHistoryEventDaoImpl extends BaseDao implements LhbTodayHistoryEventDao {

    /**
    * 插入
    * @param lhbTodayHistoryEvent
    * @return 插入的新值
    */
    @Override
    public int insert(LhbTodayHistoryEvent lhbTodayHistoryEvent) {
        return this.sqlSessionTemplate.insert("lhb_today_history_event.insert", lhbTodayHistoryEvent);
    }

    /**
    * 更新
    * @param lhbTodayHistoryEvent
    * @return 成功条数
    */
    @Override
    public int update(LhbTodayHistoryEvent lhbTodayHistoryEvent) {
        return sqlSessionTemplate.update("lhb_today_history_event.update", lhbTodayHistoryEvent);
    }

    /**
    * 查询
    * @param lhbTodayHistoryEvent
    * @return 结果列表
    */
    @Override
    public List<LhbTodayHistoryEvent> find(LhbTodayHistoryEventQuery lhbTodayHistoryEvent) {
        return this.sqlSessionTemplate.selectList("lhb_today_history_event.find", lhbTodayHistoryEvent);
    }

    /**
    * 根据ID查询
    * @param id
    * @return
    */
    @Override
    public LhbTodayHistoryEvent findById(Long id) {
        return (LhbTodayHistoryEvent) this.sqlSessionTemplate.selectOne("lhb_today_history_event.findById", id);
    }
}