/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.dao.impl;

import com.lhb.dao.LhbJokeDao;
import com.lhb.domain.pojo.LhbJoke;
import com.lhb.domain.query.LhbJokeQuery;

import com.lhb.dao.base.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* 开心一刻表DAO层实现
*
* @author lianghuaibin
* @since 2016/05/05
*/
@Repository("lhbJokeDao")
public class LhbJokeDaoImpl extends BaseDao implements LhbJokeDao {

    /**
    * 插入
    * @param lhbJoke
    * @return 插入的新值
    */
    @Override
    public int insert(LhbJoke lhbJoke) {
        return this.sqlSessionTemplate.insert("lhb_joke.insert", lhbJoke);
    }

    /**
    * 更新
    * @param lhbJoke
    * @return 成功条数
    */
    @Override
    public int update(LhbJoke lhbJoke) {
        return sqlSessionTemplate.update("lhb_joke.update", lhbJoke);
    }

    /**
    * 查询
    * @param lhbJoke
    * @return 结果列表
    */
    @Override
    public List<LhbJoke> find(LhbJokeQuery lhbJoke) {
        return this.sqlSessionTemplate.selectList("lhb_joke.find", lhbJoke);
    }

    /**
    * 根据ID查询
    * @param id
    * @return
    */
    @Override
    public LhbJoke findById(Long id) {
        return (LhbJoke) this.sqlSessionTemplate.selectOne("lhb_joke.findById", id);
    }
}