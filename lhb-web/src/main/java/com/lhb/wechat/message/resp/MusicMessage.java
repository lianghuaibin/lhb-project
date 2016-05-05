package com.lhb.wechat.message.resp;
/**
 * 音乐消息
 *
 * @author lhb
 * @date 2015-10-31
 */
public class MusicMessage extends BaseMessage {
	// 音乐
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}