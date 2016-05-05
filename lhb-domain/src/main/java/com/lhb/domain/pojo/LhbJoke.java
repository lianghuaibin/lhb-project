/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.domain.pojo;

import java.io.Serializable;
import java.util.Date;

/**
* 开心一刻表实体类
*
* @author lianghuaibin
* @since 2016/05/05
*/
public class LhbJoke implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;    //主键ID
    private String content;    //开心内容

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
    * 开心内容
    * @param content
    */
    public void setContent(String content) {
        this.content = content;
    }

    /**
    * 开心内容
    * @return content
    */
    public String getContent() {
        return this.content;
    }

}