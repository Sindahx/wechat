package com.test.dto.resp;

import com.test.dto.BaseMessage;
import com.test.dto.Music;

/**
 * 音乐消息  响应消息之音乐消息
 * @author Javen
 * @Email zyw205@gmail.com
 *
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