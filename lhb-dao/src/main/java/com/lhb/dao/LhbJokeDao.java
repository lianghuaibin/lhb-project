/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.dao;

import com.lhb.domain.pojo.LhbJoke;
import com.lhb.domain.query.LhbJokeQuery;
import java.util.List;

/**
* 开心一刻表DAO层接口
*
* @author lianghuaibin
* @since 2016/05/05
*/
public interface LhbJokeDao {

    /**
    * 插入
    * @param lhbJoke
    */
    int insert(LhbJoke lhbJoke);

    /**
    * 更新
    * @param lhbJoke
    */
    int update(LhbJoke lhbJoke);

    /**
    * 根据ID查询
    * @param id
    */
    LhbJoke findById(Long id);

    LhbJoke findByRandom();

    /**
    * 查询
    * @param lhbJoke
    */
    List<LhbJoke> find(LhbJokeQuery lhbJoke);
}