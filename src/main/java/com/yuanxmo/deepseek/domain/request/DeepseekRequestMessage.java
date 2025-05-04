package com.yuanxmo.deepseek.domain.request;

import com.yuanxmo.deepseek.enums.DeepseekRole;
import lombok.Data;

@Data
public class DeepseekRequestMessage {
    private String content;
    private String role;

    public DeepseekRequestMessage(DeepseekRole role) {
        this.role = role.toString();
    }

    public DeepseekRequestMessage(DeepseekRole role, String content) {
        this.content = content;
        this.role = role.toString();
    }

    public DeepseekRequestMessage(String content) {
        this(DeepseekRole.USER, content);
    }

    public static DeepseekRequestMessage createDeepseekRequestMessage(DeepseekRole role, String content) {
        return new DeepseekRequestMessage(role, content);
    }

    public static DeepseekRequestMessage createDeepseekRequestMessage(String content) {
        return new DeepseekRequestMessage(DeepseekRole.USER, content);
    }

}
