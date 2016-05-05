/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.dao.impl;

import com.lhb.dao.LhbRespMessageDao;
import com.lhb.domain.pojo.LhbRespMessage;
import com.lhb.domain.query.LhbRespMessageQuery;

import com.lhb.dao.base.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* 消息表DAO层实现
*
* @author lianghuaibin
* @since 2016/05/05
*/
@Repository("lhbRespMessageDao")
public class LhbRespMessageDaoImpl extends BaseDao implements LhbRespMessageDao {

    /**
    * 插入
    * @param lhbRespMessage
    * @return 插入的新值
    */
    @Override
    public int insert(LhbRespMessage lhbRespMessage) {
        return this.sqlSessionTemplate.insert("lhb_resp_message.insert", lhbRespMessage);
    }

    /**
    * 更新
    * @param lhbRespMessage
    * @return 成功条数
    */
    @Override
    public int update(LhbRespMessage lhbRespMessage) {
        return sqlSessionTemplate.update("lhb_resp_message.update", lhbRespMessage);
    }

    /**
    * 查询
    * @param lhbRespMessage
    * @return 结果列表
    */
    @Override
    public List<LhbRespMessage> find(LhbRespMessageQuery lhbRespMessage) {
        return this.sqlSessionTemplate.selectList("lhb_resp_message.find", lhbRespMessage);
    }

    /**
    * 根据ID查询
    * @param id
    * @return
    */
    @Override
    public LhbRespMessage findById(Long id) {
        return (LhbRespMessage) this.sqlSessionTemplate.selectOne("lhb_resp_message.findById", id);
    }
}