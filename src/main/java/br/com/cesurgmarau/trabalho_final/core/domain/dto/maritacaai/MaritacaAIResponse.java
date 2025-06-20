package br.com.cesurgmarau.trabalho_final.core.domain.dto.maritacaai;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MaritacaAIResponse {
    public String id;
    public String object;
    public List<Choice> choices;
    public long created;
    public String model;

    @JsonProperty("service_tier")
    public String serviceTier;

    @JsonProperty("system_fingerprint")
    public String systemFingerprint;

    public Usage usage;

    public static class Choice {
        public int index;
        public Message message;
        public Object logprobs;

        @JsonProperty("finish_reason")
        public String finishReason;

    }

    public static class Message {
        public String role;
        public String feedback;
        public String content;

        @JsonProperty("tool_call_id")
        public String toolCallId;

        @JsonProperty("tool_calls")
        public Object toolCalls;

        public Object files;
        public Object references;
    }

    public static class Usage {
        @JsonProperty("completion_tokens")
        public int completionTokens;

        @JsonProperty("prompt_tokens")
        public int promptTokens;

        @JsonProperty("total_tokens")
        public int totalTokens;
    }
}