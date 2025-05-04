package com.yuanxmo.deepseek.client;

import com.google.gson.Gson;
import com.yuanxmo.deepseek.domain.request.DeepseekRequest;
import com.yuanxmo.deepseek.domain.request.DeepseekRequestMessage;
import com.yuanxmo.deepseek.domain.response.DeepseekResponse;
import com.yuanxmo.deepseek.enums.DeepseekRole;
import com.yuanxmo.deepseek.properties.DeepseekProperties;
import com.yuanxmo.deepseek.utils.DeepseekModelUtils;
import com.yuanxmo.deepseek.utils.DeepseekUrlUtils;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class DeepseekClient {

    private DeepseekProperties properties;
    private DeepseekRequestMessage systemMessage;
    private OkHttpClient client = new OkHttpClient();

    public DeepseekClient(@Autowired DeepseekProperties deepseekProperties) {
        this.properties = deepseekProperties;
        if (!(deepseekProperties.getSystemMessage().isEmpty())) {
            this.systemMessage = new DeepseekRequestMessage(
                    DeepseekRole.SYSTEM, deepseekProperties.getSystemMessage()
            );
        }
    }


    private Request getRequest(DeepseekRequest request) {
        return new Request.Builder()
                .url(DeepseekUrlUtils.getUrl(properties.getMode()))
                .addHeader("Content-Type", "application/json")
                .addHeader("Authorization", "Bearer " + properties.getAppKey())
                .post(RequestBody.create(request.toJson(), MediaType.parse("application/json")))
                .build();
    }

    private DeepseekRequest getDeepseekRequest(String msg) {
        DeepseekRequest deepseekRequest = new DeepseekRequest(
                DeepseekModelUtils.getDeepseekModel(properties.getModel()),
                systemMessage,
                msg
        );
        return deepseekRequest;
    }

    public DeepseekResponse newCall(String msg) {
        DeepseekRequest deepseekRequest = getDeepseekRequest(msg);
        Request request = getRequest(deepseekRequest);
        Response response;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Gson gson = new Gson();
        DeepseekResponse deepseekResponse = gson.fromJson(response.body().charStream(), DeepseekResponse.class);
        deepseekResponse.getChoices().stream().forEach(choice -> {
            choice.getMessage().setContent(
                    choice.getMessage().getContent().replace("```json", "").replace("```", "").trim()
            );
        });
        return deepseekResponse;
    }
}
