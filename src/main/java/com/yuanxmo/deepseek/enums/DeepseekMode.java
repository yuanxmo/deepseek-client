package com.yuanxmo.deepseek.enums;

public enum DeepseekMode {
    CHAT("chat");

    private String value;
    DeepseekMode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
