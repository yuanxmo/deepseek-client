package com.yuanxmo.deepseek.enums;

public enum DeepseekUrl {

    BASE_URL("https://api.deepseek.com"),
    CHAT("/chat/completions");


    private String value;

    DeepseekUrl(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
