package com.yuanxmo.deepseek.domain.response;
import lombok.Data;

import java.util.List;

@Data
public class DeepseekResponse {
    private String id;
    private String object;
    private long created;
    private String model;
    private List<Choice> choices;
    private Usage usage;
    private String system_fingerprint;

    @Override
    public String toString() {
        return "DeepseekResponse{" +
                "id='" + id + '\'' +
                ", object='" + object + '\'' +
                ", created=" + created +
                ", model='" + model + '\'' +
                ", choices=" + choices +
                ", usage=" + usage +
                ", system_fingerprint='" + system_fingerprint + '\'' +
                '}';
    }

}