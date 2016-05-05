/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.service;

import com.lhb.domain.query.LhbUserQuery;
import com.lhb.domain.pojo.LhbUser;
import java.util.List;

/**
* 用户表Service层接口
*
* @author lianghuaibin
* @since 2016/05/05
*/
public interface LhbUserService {

    /**
    * 插入
    * @param lhbUser
    * @return 新增记录ID
    */
    int insert(LhbUser lhbUser);

    /**
    * 更新
    * @param lhbUser
    * @return 更新影响数据条数
    */
    int update(LhbUser lhbUser);

    /**
    * 根据ID查询
    * @param id
    * @return
    */
    LhbUser findById(Long id);

    /**
    * 查询
    * @param lhbUser
    * @return
    */
    List<LhbUser> find(LhbUserQuery lhbUser);
}