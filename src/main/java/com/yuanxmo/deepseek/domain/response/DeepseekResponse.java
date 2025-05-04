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

    public <T> T getResultObject(Class<T> clazz) {
        return getResultObject(0, clazz);
    }

    public <T> T getResultObject(int index, Class<T> clazz) {
        if (index < 0 || index >= this.choices.size()) {
            return null;
        }
        return DeepseekUtils.getResult(this.choices.get(index).getMessage().getContent(), clazz);
    }

    public <T> List<T> getResultList(Class<T> clazz) {
        ArrayList<T> ts = new ArrayList<>();
        for (int i = 0; i < this.choices.size(); i++) {
            ts.add(this.getResultObject(i, clazz));
        }
        return ts;
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