package br.com.cesurgmarau.trabalho_final.core.dto;

import java.util.List;

public class ChatGPTRequestDTO {

    private String model;
    private List<Message> messages;
    private Integer max_tokens;
    private Double temperature;

    public ChatGPTRequestDTO() {
    }

    public ChatGPTRequestDTO(String model, List<Message> messages, Integer max_tokens, Double temperature) {
        this.model = model;
        this.messages = messages;
        this.max_tokens = max_tokens;
        this.temperature = temperature;
    }

    // Getters e Setters

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public Integer getMax_tokens() {
        return max_tokens;
    }

    public void setMax_tokens(Integer max_tokens) {
        this.max_tokens = max_tokens;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public static class Message {
        private String role; // ex: "system", "user"
        private String content;

        public Message() {
        }

        public Message(String role, String content) {
            this.role = role;
            this.content = content;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}

