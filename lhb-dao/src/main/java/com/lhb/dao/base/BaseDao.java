package com.lhb.dao.base;

import org.mybatis.spring.SqlSessionTemplate;

/**
 * Dao层父类
 * @author lianghuaibin
 * @since 2016/5/5
 */
public class BaseDao {
    protected SqlSessionTemplate sqlSessionTemplate;
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }
}
