/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.service;

import com.lhb.domain.query.LhbJokeQuery;
import com.lhb.domain.pojo.LhbJoke;
import java.util.List;

/**
* 开心一刻表Service层接口
*
* @author lianghuaibin
* @since 2016/05/05
*/
public interface LhbJokeService {

    /**
    * 插入
    * @param lhbJoke
    * @return 新增记录ID
    */
    int insert(LhbJoke lhbJoke);

    /**
    * 更新
    * @param lhbJoke
    * @return 更新影响数据条数
    */
    int update(LhbJoke lhbJoke);

    /**
    * 根据ID查询
    * @param id
    * @return
    */
    LhbJoke findById(Long id);

    /**
    * 查询
    * @param lhbJoke
    * @return
    */
    List<LhbJoke> find(LhbJokeQuery lhbJoke);
}