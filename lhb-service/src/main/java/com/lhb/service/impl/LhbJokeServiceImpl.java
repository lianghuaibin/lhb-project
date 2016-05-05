/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.service.impl;

import com.lhb.dao.LhbJokeDao;
import com.lhb.domain.pojo.LhbJoke;
import com.lhb.domain.query.LhbJokeQuery;
import com.lhb.service.LhbJokeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* 开心一刻表Service层实现
*
* @author lianghuaibin
* @since 2016/05/05
*/
@Service("lhbJokeService")
public class LhbJokeServiceImpl implements LhbJokeService {

    private static Log log = LogFactory.getLog(LhbJokeServiceImpl.class);

    @Resource
    private LhbJokeDao lhbJokeDao;

    /**
    * 插入
    * @param lhbJoke
    */
    @Override
    public int insert(LhbJoke lhbJoke) {
        log.debug("insert---执行");
        return lhbJokeDao.insert(lhbJoke);
    }

    /**
    * 更新
    * @param lhbJoke
    */
    @Override
    public int update(LhbJoke lhbJoke) {
        log.debug("update---执行");
        return this.lhbJokeDao.update(lhbJoke);
    }

    /**
    * 根据ID查询
    * @param id
    */
    @Override
    public LhbJoke findById(Long id) {
        log.debug("findById---执行");
        return this.lhbJokeDao.findById(id);
    }

    @Override
    public LhbJoke findByRandom() {
        return lhbJokeDao.findByRandom();
    }

    /**
    * 查询
    * @param lhbJoke
    */
    @Override
    public List<LhbJoke> find(LhbJokeQuery lhbJoke) {
    log.debug("find---执行");
    return this.lhbJokeDao.find(lhbJoke);
    }
}