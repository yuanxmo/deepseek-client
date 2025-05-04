package com.yuanxmo.deepseek.domain.response;

import lombok.Data;

@Data
public class Usage {
    private int prompt_tokens;
    private int completion_tokens;
    private int total_tokens;
    private PromptTokensDetails prompt_tokens_details;
    private int prompt_cache_hit_tokens;
    private int prompt_cache_miss_tokens;

    @Override
    public String toString() {
        return "{" +
                "prompt_tokens=" + prompt_tokens +
                ", completion_tokens=" + completion_tokens +
                ", total_tokens=" + total_tokens +
                ", prompt_tokens_details=" + prompt_tokens_details +
                ", prompt_cache_hit_tokens=" + prompt_cache_hit_tokens +
                ", prompt_cache_miss_tokens=" + prompt_cache_miss_tokens +
                '}';
    }
}
