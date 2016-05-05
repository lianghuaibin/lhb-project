/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.dao.impl;

import com.lhb.dao.LhbRomanticDao;
import com.lhb.domain.pojo.LhbRomantic;
import com.lhb.domain.query.LhbRomanticQuery;

import com.lhb.dao.base.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* 浪漫花语表DAO层实现
*
* @author lianghuaibin
* @since 2016/05/05
*/
@Repository("lhbRomanticDao")
public class LhbRomanticDaoImpl extends BaseDao implements LhbRomanticDao {

    /**
    * 插入
    * @param lhbRomantic
    * @return 插入的新值
    */
    @Override
    public int insert(LhbRomantic lhbRomantic) {
        return this.sqlSessionTemplate.insert("lhb_romantic.insert", lhbRomantic);
    }

    /**
    * 更新
    * @param lhbRomantic
    * @return 成功条数
    */
    @Override
    public int update(LhbRomantic lhbRomantic) {
        return sqlSessionTemplate.update("lhb_romantic.update", lhbRomantic);
    }

    /**
    * 查询
    * @param lhbRomantic
    * @return 结果列表
    */
    @Override
    public List<LhbRomantic> find(LhbRomanticQuery lhbRomantic) {
        return this.sqlSessionTemplate.selectList("lhb_romantic.find", lhbRomantic);
    }

    /**
    * 根据ID查询
    * @param id
    * @return
    */
    @Override
    public LhbRomantic findById(Long id) {
        return (LhbRomantic) this.sqlSessionTemplate.selectOne("lhb_romantic.findById", id);
    }

    @Override
    public LhbRomantic findByRandom() {
        return sqlSessionTemplate.selectOne("lhb_romantic.findByRandom");
    }
}