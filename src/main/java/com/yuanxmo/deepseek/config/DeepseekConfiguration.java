package com.yuanxmo.deepseek.config;

import com.yuanxmo.deepseek.client.DeepseekClient;
import com.yuanxmo.deepseek.properties.DeepseekProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DeepseekConfiguration {

    @Bean
    public DeepseekClient deepseekClient(@Autowired DeepseekProperties deepseekProperties) {
        return new DeepseekClient(deepseekProperties);
    }

}
