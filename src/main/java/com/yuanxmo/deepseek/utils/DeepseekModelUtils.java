package com.yuanxmo.deepseek.utils;

import com.yuanxmo.deepseek.enums.DeepseekModel;

public class DeepseekModelUtils {
    private DeepseekModelUtils() {}

    public static DeepseekModel getDeepseekModel(String model) {
        if (model == null) {
            return DeepseekModel.V3;
        }
        model = model.toUpperCase();
        if (model.equals("R1")) {
            return DeepseekModel.R1;
        }
        return DeepseekModel.V3;
    }
}
