/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.domain.pojo;

import java.io.Serializable;
import java.util.Date;

/**
* 历史今天表实体类
*
* @author lianghuaibin
* @since 2016/05/05
*/
public class LhbTodayHistoryEvent implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;    //主键ID
    private String datetag;    //发生的时间（M月d日）
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
    * 发生的时间（M月d日）
    * @param datetag
    */
    public void setDatetag(String datetag) {
        this.datetag = datetag;
    }

    /**
    * 发生的时间（M月d日）
    * @return datetag
    */
    public String getDatetag() {
        return this.datetag;
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