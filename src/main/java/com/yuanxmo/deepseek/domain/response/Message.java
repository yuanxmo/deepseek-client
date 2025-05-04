package com.yuanxmo.deepseek.domain.response;

import lombok.Data;

@Data
public class Message {
    private String role;
    private String content;

    @Override
    public String toString() {
        return "Message{" +
                "role='" + role + '\'' +
                ", content=" + content +
                '}';
    }
}
