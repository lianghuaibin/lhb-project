/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.service.impl;

import com.lhb.dao.LhbRomanticDao;
import com.lhb.domain.pojo.LhbRomantic;
import com.lhb.domain.query.LhbRomanticQuery;
import com.lhb.service.LhbRomanticService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* 浪漫花语表Service层实现
*
* @author lianghuaibin
* @since 2016/05/05
*/
@Service("lhbRomanticService")
public class LhbRomanticServiceImpl implements LhbRomanticService {

    private static Log log = LogFactory.getLog(LhbRomanticServiceImpl.class);

    @Resource
    private LhbRomanticDao lhbRomanticDao;

    /**
    * 插入
    * @param lhbRomantic
    */
    @Override
    public int insert(LhbRomantic lhbRomantic) {
        log.debug("insert---执行");
        return lhbRomanticDao.insert(lhbRomantic);
    }

    /**
    * 更新
    * @param lhbRomantic
    */
    @Override
    public int update(LhbRomantic lhbRomantic) {
        log.debug("update---执行");
        return this.lhbRomanticDao.update(lhbRomantic);
    }

    /**
    * 根据ID查询
    * @param id
    */
    @Override
    public LhbRomantic findById(Long id) {
        log.debug("findById---执行");
        return this.lhbRomanticDao.findById(id);
    }

    /**
    * 查询
    * @param lhbRomantic
    */
    @Override
    public List<LhbRomantic> find(LhbRomanticQuery lhbRomantic) {
    log.debug("find---执行");
    return this.lhbRomanticDao.find(lhbRomantic);
    }
}