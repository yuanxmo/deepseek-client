package com.yuanxmo.deepseek.domain.response;

import lombok.Data;

@Data
public class Choice {
    private int index;
    private Message message;
    private Object logprobs;
    private String finish_reason;

    @Override
    public String toString() {
        return "Choice{" +
                "index=" + index +
                ", message=" + message +
                ", logprobs=" + logprobs +
                ", finish_reason='" + finish_reason + '\'' +
                '}';
    }
}
