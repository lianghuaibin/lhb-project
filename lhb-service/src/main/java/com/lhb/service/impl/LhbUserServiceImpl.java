/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.service.impl;

import com.lhb.dao.LhbUserDao;
import com.lhb.domain.pojo.LhbUser;
import com.lhb.domain.query.LhbUserQuery;
import com.lhb.service.LhbUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* 用户表Service层实现
*
* @author lianghuaibin
* @since 2016/05/05
*/
@Service("lhbUserService")
public class LhbUserServiceImpl implements LhbUserService {

    private static Log log = LogFactory.getLog(LhbUserServiceImpl.class);

    @Resource
    private LhbUserDao lhbUserDao;

    /**
    * 插入
    * @param lhbUser
    */
    @Override
    public int insert(LhbUser lhbUser) {
        log.debug("insert---执行");
        return lhbUserDao.insert(lhbUser);
    }

    /**
    * 更新
    * @param lhbUser
    */
    @Override
    public int update(LhbUser lhbUser) {
        log.debug("update---执行");
        return this.lhbUserDao.update(lhbUser);
    }

    /**
    * 根据ID查询
    * @param id
    */
    @Override
    public LhbUser findById(Long id) {
        log.debug("findById---执行");
        return this.lhbUserDao.findById(id);
    }

    /**
    * 查询
    * @param lhbUser
    */
    @Override
    public List<LhbUser> find(LhbUserQuery lhbUser) {
    log.debug("find---执行");
    return this.lhbUserDao.find(lhbUser);
    }
}