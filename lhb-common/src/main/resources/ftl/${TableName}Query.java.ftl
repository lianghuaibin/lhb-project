/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package ${packagePath}.domain.query.${TableName};

import java.io.Serializable;
import java.util.Date;

/**
* ${tableComment}查询实体类
*
* @author ${author}
* @since ${since}
*/
public class ${TableName}Query implements Serializable {

    private static final long serialVersionUID = 1L;

    <#list columns as item>
    private ${item.dataType} ${item.columnName};    //${item.columnComment}
    </#list>

    <#list columns as item>
    /**
    * ${item.columnComment}
    * @param ${item.columnName}
    */
    public void set${item.ColumnName}(${item.dataType} ${item.columnName}) {
        this.${item.columnName} = ${item.columnName};
    }

    /**
    * ${item.columnComment}
    * @return ${item.columnName}
    */
    public ${item.dataType} get${item.ColumnName}() {
        return this.${item.columnName};
    }

    </#list>
}