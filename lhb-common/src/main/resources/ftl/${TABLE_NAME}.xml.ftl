<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${table_name}">

    <sql id="wherecontation">
    <#list columns as item>
        /* ${item.columnComment} */
        <if test="${item.columnName}!=null and ${item.columnName}!=''">
            AND ${item.COLUMN_NAME} = @{${item.columnName}}
        </if>
    </#list>
    </sql>

    <!-- 插入 -->
    <insert id="insert" parameterType="${packagePath}.domain.pojo.${TableName}" useGeneratedKeys="true" keyProperty="id" >
        INSERT INTO ${table_name}
        (
        <#list columns as item>
            ${item.COLUMN_NAME}<#if item_has_next>,</#if>    /* ${item.columnComment} */
        </#list>
        )
        VALUES
        (
        <#list columns as item>
            @{${item.columnName}}<#if item_has_next>,</#if>
        </#list>
        )
    </insert>

    <!-- 更新 -->
    <update id="update" parameterType="${packagePath}.domain.pojo.${TableName}" >
        UPDATE ${table_name}
        <trim prefix=" SET " suffixOverrides=",">
        <#list columns as item>
            /* ${item.columnComment} */
            <if test="${item.columnName}!=null and ${item.columnName}!=''">
                ${item.COLUMN_NAME} = @{${item.columnName}},
            </if>
        </#list>
        </trim>
        WHERE ID = @{id}
    </update>

    <!-- 根据主键查找 -->
    <select id="findById" parameterType="java.lang.Long" resultType="${packagePath}.domain.pojo.${TableName}">
        SELECT
            <#list columns as item>
            ${item.COLUMN_NAME} AS ${item.columnName}<#if item_has_next>,</#if>  /* ${item.columnComment} */
            </#list>
        FROM ${table_name}
        WHERE ID = @{id}
    </select>

    <!-- 查询 -->
    <select id="find" parameterType="${packagePath}.domain.query.${TableName}Query" resultType="${packagePath}.domain.pojo.${TableName}">
        SELECT
            <#list columns as item>
            ${item.COLUMN_NAME} AS ${item.columnName}<#if item_has_next>,</#if>  /* ${item.columnComment} */
            </#list>
        FROM ${table_name}
        WHERE 1=1
        <include refid="wherecontation"/>
    </select>
</mapper>