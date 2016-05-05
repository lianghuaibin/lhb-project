/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.service;

import com.lhb.domain.query.LhbRomanticQuery;
import com.lhb.domain.pojo.LhbRomantic;
import java.util.List;

/**
* 浪漫花语表Service层接口
*
* @author lianghuaibin
* @since 2016/05/05
*/
public interface LhbRomanticService {

    /**
    * 插入
    * @param lhbRomantic
    * @return 新增记录ID
    */
    int insert(LhbRomantic lhbRomantic);

    /**
    * 更新
    * @param lhbRomantic
    * @return 更新影响数据条数
    */
    int update(LhbRomantic lhbRomantic);

    /**
    * 根据ID查询
    * @param id
    * @return
    */
    LhbRomantic findById(Long id);

    /**
    * 查询
    * @param lhbRomantic
    * @return
    */
    List<LhbRomantic> find(LhbRomanticQuery lhbRomantic);
}