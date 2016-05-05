/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package ${packagePath}.service;

import ${packagePath}.domain.query.${TableName}Query;
import ${packagePath}.domain.pojo.${TableName};
import java.util.List;

/**
* ${tableComment}Service层接口
*
* @author ${author}
* @since ${since}
*/
public interface ${TableName}Service {

    /**
    * 插入
    * @param ${tableName}
    * @return 新增记录ID
    */
    int insert(${TableName} ${tableName});

    /**
    * 更新
    * @param ${tableName}
    * @return 更新影响数据条数
    */
    int update(${TableName} ${tableName});

    /**
    * 根据ID查询
    * @param id
    * @return
    */
    ${TableName} findById(Long id);

    /**
    * 查询
    * @param ${tableName}
    * @return
    */
    List<${TableName}> find(${TableName}Query ${tableName});
}