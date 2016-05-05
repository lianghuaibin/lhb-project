/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.dao.impl;

import com.lhb.dao.LhbUserDao;
import com.lhb.dao.base.BaseDao;
import com.lhb.domain.pojo.LhbUser;
import com.lhb.domain.query.LhbUserQuery;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
* 用户表DAO层实现
*
* @author lianghuaibin
* @since 2016/05/05
*/
@Repository("lhbUserDao")
public class LhbUserDaoImpl extends BaseDao implements LhbUserDao {

    /**
    * 插入
    * @param lhbUser
    * @return 插入的新值
    */
    @Override
    public int insert(LhbUser lhbUser) {
        return this.sqlSessionTemplate.insert("lhb_user.insert", lhbUser);
    }

    /**
    * 更新
    * @param lhbUser
    * @return 成功条数
    */
    @Override
    public int update(LhbUser lhbUser) {
        return sqlSessionTemplate.update("lhb_user.update", lhbUser);
    }

    /**
    * 查询
    * @param lhbUser
    * @return 结果列表
    */
    @Override
    public List<LhbUser> find(LhbUserQuery lhbUser) {
        return this.sqlSessionTemplate.selectList("lhb_user.find", lhbUser);
    }

    /**
    * 根据ID查询
    * @param id
    * @return
    */
    @Override
    public LhbUser findById(Long id) {
        return (LhbUser) this.sqlSessionTemplate.selectOne("lhb_user.findById", id);
    }
}