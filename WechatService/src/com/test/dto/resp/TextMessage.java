package com.test.dto.resp;

import com.test.dto.BaseMessage;

/**
 * 文本消息
 * @author Javen
 * @Email zyw205@gmail.com
 *
 */
public class TextMessage extends BaseMessage {
    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
