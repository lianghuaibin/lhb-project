/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.dao;

import com.lhb.domain.pojo.LhbUser;
import com.lhb.domain.query.LhbUserQuery;
import java.util.List;

/**
* 用户表DAO层接口
*
* @author lianghuaibin
* @since 2016/05/05
*/
public interface LhbUserDao {

    /**
    * 插入
    * @param lhbUser
    */
    int insert(LhbUser lhbUser);

    /**
    * 更新
    * @param lhbUser
    */
    int update(LhbUser lhbUser);

    /**
    * 根据ID查询
    * @param id
    */
    LhbUser findById(Long id);

    /**
    * 查询
    * @param lhbUser
    */
    List<LhbUser> find(LhbUserQuery lhbUser);
}