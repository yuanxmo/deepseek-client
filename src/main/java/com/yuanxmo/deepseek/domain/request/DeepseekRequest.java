package com.yuanxmo.deepseek.domain.request;

import com.google.gson.Gson;
import com.yuanxmo.deepseek.enums.DeepseekModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DeepseekRequest {
    private String model;
    private List<DeepseekRequestMessage> messages;
    private final Boolean stream = false;

    DeepseekRequest(
            DeepseekModel deepseekModel,
            DeepseekRequestMessage systemMessage,
            DeepseekRequestMessage userMessages) {
        this.model = deepseekModel.toString();
        messages = new ArrayList<>();
        messages.add(systemMessage);
        messages.add(userMessages);
    }

    public DeepseekRequest(
            DeepseekModel deepseekModel,
            DeepseekRequestMessage systemMessage,
            String userMessage
    ) {
        this(deepseekModel, systemMessage, new DeepseekRequestMessage(userMessage));
    }

    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
