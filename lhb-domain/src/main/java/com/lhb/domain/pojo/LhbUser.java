/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.domain.pojo;

import java.io.Serializable;
import java.util.Date;

/**
* 用户表实体类
*
* @author lianghuaibin
* @since 2016/05/05
*/
public class LhbUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;    //用户ID
    private String account;    //用户账号
    private String username;    //用户姓名
    private String password;    //登陆密码
    private String headPortrait;    //头像url
    private String signature;    //个人签名
    private String cover;    //封面

    /**
    * 用户ID
    * @param id
    */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
    * 用户ID
    * @return id
    */
    public Integer getId() {
        return this.id;
    }

    /**
    * 用户账号
    * @param account
    */
    public void setAccount(String account) {
        this.account = account;
    }

    /**
    * 用户账号
    * @return account
    */
    public String getAccount() {
        return this.account;
    }

    /**
    * 用户姓名
    * @param username
    */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
    * 用户姓名
    * @return username
    */
    public String getUsername() {
        return this.username;
    }

    /**
    * 登陆密码
    * @param password
    */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
    * 登陆密码
    * @return password
    */
    public String getPassword() {
        return this.password;
    }

    /**
    * 头像url
    * @param headPortrait
    */
    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    /**
    * 头像url
    * @return headPortrait
    */
    public String getHeadPortrait() {
        return this.headPortrait;
    }

    /**
    * 个人签名
    * @param signature
    */
    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
    * 个人签名
    * @return signature
    */
    public String getSignature() {
        return this.signature;
    }

    /**
    * 封面
    * @param cover
    */
    public void setCover(String cover) {
        this.cover = cover;
    }

    /**
    * 封面
    * @return cover
    */
    public String getCover() {
        return this.cover;
    }

}