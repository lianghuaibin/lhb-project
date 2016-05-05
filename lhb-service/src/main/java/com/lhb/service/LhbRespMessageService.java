/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.service;

import com.lhb.domain.query.LhbRespMessageQuery;
import com.lhb.domain.pojo.LhbRespMessage;
import java.util.List;

/**
* 消息表Service层接口
*
* @author lianghuaibin
* @since 2016/05/05
*/
public interface LhbRespMessageService {

    /**
    * 插入
    * @param lhbRespMessage
    * @return 新增记录ID
    */
    int insert(LhbRespMessage lhbRespMessage);

    /**
    * 更新
    * @param lhbRespMessage
    * @return 更新影响数据条数
    */
    int update(LhbRespMessage lhbRespMessage);

    /**
    * 根据ID查询
    * @param id
    * @return
    */
    LhbRespMessage findById(Long id);

    /**
    * 查询
    * @param lhbRespMessage
    * @return
    */
    List<LhbRespMessage> find(LhbRespMessageQuery lhbRespMessage);
}