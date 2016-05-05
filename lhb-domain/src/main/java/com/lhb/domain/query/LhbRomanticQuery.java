/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.domain.query;

import java.io.Serializable;
import java.util.Date;

/**
* 浪漫花语表查询实体类
*
* @author lianghuaibin
* @since 2016/05/05
*/
public class LhbRomanticQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;    //主键ID
    private String content;    //内容

    /**
    * 主键ID
    * @param id
    */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
    * 主键ID
    * @return id
    */
    public Integer getId() {
        return this.id;
    }

    /**
    * 内容
    * @param content
    */
    public void setContent(String content) {
        this.content = content;
    }

    /**
    * 内容
    * @return content
    */
    public String getContent() {
        return this.content;
    }

}