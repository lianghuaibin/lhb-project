/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.dao;

import com.lhb.domain.pojo.LhbRespMessage;
import com.lhb.domain.query.LhbRespMessageQuery;
import java.util.List;

/**
* 消息表DAO层接口
*
* @author lianghuaibin
* @since 2016/05/05
*/
public interface LhbRespMessageDao {

    /**
    * 插入
    * @param lhbRespMessage
    */
    int insert(LhbRespMessage lhbRespMessage);

    /**
    * 更新
    * @param lhbRespMessage
    */
    int update(LhbRespMessage lhbRespMessage);

    /**
    * 根据ID查询
    * @param id
    */
    LhbRespMessage findById(Long id);

    /**
    * 查询
    * @param lhbRespMessage
    */
    List<LhbRespMessage> find(LhbRespMessageQuery lhbRespMessage);
}