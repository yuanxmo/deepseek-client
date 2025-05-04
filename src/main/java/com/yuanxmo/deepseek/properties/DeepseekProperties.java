package com.yuanxmo.deepseek.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "yuanxmo.deepseek")
public class DeepseekProperties {
    private String appKey;

    private String model = "deepseek-chat";

    private String mode = "chat";

    private String systemMessage;
}
