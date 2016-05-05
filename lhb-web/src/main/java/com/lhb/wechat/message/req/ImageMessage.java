package com.lhb.wechat.message.req;

/**
 * 图片消息
 *
 * @author lhb
 * @date 2015-10-31
 */
public class ImageMessage extends BaseMessage {
    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}
