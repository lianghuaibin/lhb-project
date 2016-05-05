/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package ${packagePath}.dao.impl;

import ${packagePath}.dao.${TableName}Dao;
import ${packagePath}.domain.pojo.${TableName};
import ${packagePath}.domain.query.${TableName}Query;

import com.lhb.dao.base.BaseDao;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* ${tableComment}DAO层实现
*
* @author ${author}
* @since ${since}
*/
@Repository("${tableName}Dao")
public class ${TableName}DaoImpl extends BaseDao implements ${TableName}Dao {

    /**
    * 插入
    * @param ${tableName}
    * @return 插入的新值
    */
    @Override
    public int insert(${TableName} ${tableName}) {
        return this.sqlSessionTemplate.insert("${table_name}.insert", ${tableName});
    }

    /**
    * 更新
    * @param ${tableName}
    * @return 成功条数
    */
    @Override
    public int update(${TableName} ${tableName}) {
        return sqlSessionTemplate.update("${table_name}.update", ${tableName});
    }

    /**
    * 查询
    * @param ${tableName}
    * @return 结果列表
    */
    @Override
    public List<${TableName}> find(${TableName}Query ${tableName}) {
        return this.sqlSessionTemplate.selectList("${table_name}.find", ${tableName});
    }

    /**
    * 根据ID查询
    * @param id
    * @return
    */
    @Override
    public ${TableName} findById(Long id) {
        return (${TableName}) this.sqlSessionTemplate.selectOne("${table_name}.findById", id);
    }
}