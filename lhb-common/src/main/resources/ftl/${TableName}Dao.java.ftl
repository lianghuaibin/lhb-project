/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package ${packagePath}.dao;

import ${packagePath}.domain.pojo.${TableName};
import ${packagePath}.domain.query.${TableName}Query;
import java.util.List;

/**
* ${tableComment}DAO层接口
*
* @author ${author}
* @since ${since}
*/
public interface ${TableName}Dao {

    /**
    * 插入
    * @param ${tableName}
    */
    int insert(${TableName} ${tableName});

    /**
    * 更新
    * @param ${tableName}
    */
    int update(${TableName} ${tableName});

    /**
    * 根据ID查询
    * @param id
    */
    ${TableName} findById(Long id);

    /**
    * 查询
    * @param ${tableName}
    */
    List<${TableName}> find(${TableName}Query ${tableName});
}