/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package ${packagePath}.service.impl;

import ${packagePath}.dao.${TableName}Dao;
import ${packagePath}.domain.pojo.${TableName};
import ${packagePath}.domain.query.${TableName}Query;
import ${packagePath}.service.${TableName}Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* ${tableComment}Service层实现
*
* @author ${author}
* @since ${since}
*/
@Service("${tableName}Service")
public class ${TableName}ServiceImpl implements ${TableName}Service {

    private static Log log = LogFactory.getLog(${TableName}ServiceImpl.class);

    @Resource
    private ${TableName}Dao ${tableName}Dao;

    /**
    * 插入
    * @param ${tableName}
    */
    @Override
    public int insert(${TableName} ${tableName}) {
        log.debug("insert---执行");
        return ${tableName}Dao.insert(${tableName});
    }

    /**
    * 更新
    * @param ${tableName}
    */
    @Override
    public int update(${TableName} ${tableName}) {
        log.debug("update---执行");
        return this.${tableName}Dao.update(${tableName});
    }

    /**
    * 根据ID查询
    * @param id
    */
    @Override
    public ${TableName} findById(Long id) {
        log.debug("findById---执行");
        return this.${tableName}Dao.findById(id);
    }

    /**
    * 查询
    * @param ${tableName}
    */
    @Override
    public List<${TableName}> find(${TableName}Query ${tableName}) {
    log.debug("find---执行");
    return this.${tableName}Dao.find(${tableName});
    }
}