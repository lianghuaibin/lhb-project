/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.dao;

import com.lhb.domain.pojo.LhbRomantic;
import com.lhb.domain.query.LhbRomanticQuery;
import java.util.List;

/**
* 浪漫花语表DAO层接口
*
* @author lianghuaibin
* @since 2016/05/05
*/
public interface LhbRomanticDao {

    /**
    * 插入
    * @param lhbRomantic
    */
    int insert(LhbRomantic lhbRomantic);

    /**
    * 更新
    * @param lhbRomantic
    */
    int update(LhbRomantic lhbRomantic);

    /**
    * 根据ID查询
    * @param id
    */
    LhbRomantic findById(Long id);

    LhbRomantic findByRandom();

    /**
    * 查询
    * @param lhbRomantic
    */
    List<LhbRomantic> find(LhbRomanticQuery lhbRomantic);
}