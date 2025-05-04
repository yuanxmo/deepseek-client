package com.yuanxmo.deepseek.enums;

public enum DeepseekModel {
    V3("deepseek-chat"),
    R1("deepseek-reasoner");

    private String value;
    DeepseekModel(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
