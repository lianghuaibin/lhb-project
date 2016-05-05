/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.service.impl;

import com.lhb.dao.LhbRespMessageDao;
import com.lhb.domain.pojo.LhbRespMessage;
import com.lhb.domain.query.LhbRespMessageQuery;
import com.lhb.service.LhbRespMessageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* 消息表Service层实现
*
* @author lianghuaibin
* @since 2016/05/05
*/
@Service("lhbRespMessageService")
public class LhbRespMessageServiceImpl implements LhbRespMessageService {

    private static Log log = LogFactory.getLog(LhbRespMessageServiceImpl.class);

    @Resource
    private LhbRespMessageDao lhbRespMessageDao;

    /**
    * 插入
    * @param lhbRespMessage
    */
    @Override
    public int insert(LhbRespMessage lhbRespMessage) {
        log.debug("insert---执行");
        return lhbRespMessageDao.insert(lhbRespMessage);
    }

    /**
    * 更新
    * @param lhbRespMessage
    */
    @Override
    public int update(LhbRespMessage lhbRespMessage) {
        log.debug("update---执行");
        return this.lhbRespMessageDao.update(lhbRespMessage);
    }

    /**
    * 根据ID查询
    * @param id
    */
    @Override
    public LhbRespMessage findById(Long id) {
        log.debug("findById---执行");
        return this.lhbRespMessageDao.findById(id);
    }

    /**
    * 查询
    * @param lhbRespMessage
    */
    @Override
    public List<LhbRespMessage> find(LhbRespMessageQuery lhbRespMessage) {
    log.debug("find---执行");
    return this.lhbRespMessageDao.find(lhbRespMessage);
    }
}