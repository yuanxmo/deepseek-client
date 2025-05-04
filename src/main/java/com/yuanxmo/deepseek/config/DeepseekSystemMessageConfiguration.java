package com.yuanxmo.deepseek.config;

import com.yuanxmo.deepseek.domain.request.DeepseekRequestMessage;
import com.yuanxmo.deepseek.enums.DeepseekRole;
import com.yuanxmo.deepseek.properties.DeepseekProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeepseekSystemMessageConfiguration {

    @Autowired
    private DeepseekProperties deepseekProperties;

    @Bean
    public DeepseekRequestMessage deepseekRequest() {
        DeepseekRequestMessage deepseekRequestMessage = new DeepseekRequestMessage(DeepseekRole.SYSTEM);
        if (deepseekProperties == null || deepseekProperties.getSystemMessage() == null) {
            return deepseekRequestMessage;
        }
        deepseekRequestMessage.setContent(deepseekProperties.getSystemMessage());
        return deepseekRequestMessage;
    }
}
