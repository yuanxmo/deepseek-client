package com.yuanxmo.deepseek.enums;

public enum DeepseekRole {
    USER("user"),
    SYSTEM("system");

    private String value;
    private DeepseekRole(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
