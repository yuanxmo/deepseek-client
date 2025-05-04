package com.yuanxmo.deepseek.domain.response;
import com.yuanxmo.deepseek.utils.DeepseekUtils;
import lombok.Data;

import java.util.ArrayList;
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

    public <T> T getResult(Class<T> clazz) {
        return DeepseekUtils.getResult(this.choices.get(0).getMessage().getContent(), clazz);
    }

    public List<String> getResults() {
        ArrayList<String> contents = new ArrayList<>();
        for (Choice choice : choices) {
            String content = choice.getMessage().getContent();
            contents.add(content);
        }
        return contents;
    }

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