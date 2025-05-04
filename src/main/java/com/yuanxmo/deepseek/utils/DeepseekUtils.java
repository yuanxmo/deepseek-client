package com.yuanxmo.deepseek.utils;

import com.google.gson.Gson;

public class DeepseekUtils {
    private DeepseekUtils() {}

    public static <T> T getResult(String content, Class<T> clazz) {
        return new Gson().fromJson(content, clazz);
    }

}
