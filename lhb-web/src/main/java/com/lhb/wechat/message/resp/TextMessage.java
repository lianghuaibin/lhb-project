package com.lhb.wechat.message.resp;

import com.lhb.wechat.message.req.BaseMessage;

/**
 * 文本消息
 *
 * @author lhb
 * @date 2015-10-31
 */
public class TextMessage extends BaseMessage {
	// 回复消息内容
	private String Content;

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
