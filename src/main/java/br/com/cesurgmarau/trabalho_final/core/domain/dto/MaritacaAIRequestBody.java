package br.com.cesurgmarau.trabalho_final.core.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MaritacaAIRequestBody {
    public String model;
    public List<Message> messages;

    @JsonProperty("max_tokens")
    public int maxTokens;

    public static class Message {
        public String role;
        public String content;
    }
}