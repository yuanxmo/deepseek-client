package com.yuanxmo.deepseek.utils;

import com.yuanxmo.deepseek.enums.DeepseekMode;
import com.yuanxmo.deepseek.enums.DeepseekUrl;

public class DeepseekUrlUtils {

    private DeepseekUrlUtils() {}

    public static String getUrl(String mode) {
        String url = DeepseekUrl.BASE_URL.toString();
        DeepseekMode deepseekMode = DeepseekMode.valueOf(mode.toUpperCase());
        switch (deepseekMode) {
            default:
                url = url + DeepseekUrl.CHAT.toString();
                break;
        }
        return url;
    }
}
