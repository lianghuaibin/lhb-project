/*
* Copyright (c) 2016, lianghuaibin All Rights Reserved.
*/
package com.lhb.domain.pojo;

import java.io.Serializable;
import java.util.Date;

/**
* 消息表实体类
*
* @author lianghuaibin
* @since 2016/05/05
*/
public class LhbRespMessage implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;    //返回消息ID
    private String msgContent;    //返回消息内容
    private String msgType;    //返回消息类型(text:文本;music:音乐;news:图文;)
    private String msgTitle;    //消息标题
    private String msgPic;    //消息图片链接
    private String skipUrl;    //点击跳转链接

    /**
    * 返回消息ID
    * @param id
    */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
    * 返回消息ID
    * @return id
    */
    public Integer getId() {
        return this.id;
    }

    /**
    * 返回消息内容
    * @param msgContent
    */
    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    /**
    * 返回消息内容
    * @return msgContent
    */
    public String getMsgContent() {
        return this.msgContent;
    }

    /**
    * 返回消息类型(text:文本;music:音乐;news:图文;)
    * @param msgType
    */
    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    /**
    * 返回消息类型(text:文本;music:音乐;news:图文;)
    * @return msgType
    */
    public String getMsgType() {
        return this.msgType;
    }

    /**
    * 消息标题
    * @param msgTitle
    */
    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    /**
    * 消息标题
    * @return msgTitle
    */
    public String getMsgTitle() {
        return this.msgTitle;
    }

    /**
    * 消息图片链接
    * @param msgPic
    */
    public void setMsgPic(String msgPic) {
        this.msgPic = msgPic;
    }

    /**
    * 消息图片链接
    * @return msgPic
    */
    public String getMsgPic() {
        return this.msgPic;
    }

    /**
    * 点击跳转链接
    * @param skipUrl
    */
    public void setSkipUrl(String skipUrl) {
        this.skipUrl = skipUrl;
    }

    /**
    * 点击跳转链接
    * @return skipUrl
    */
    public String getSkipUrl() {
        return this.skipUrl;
    }

}