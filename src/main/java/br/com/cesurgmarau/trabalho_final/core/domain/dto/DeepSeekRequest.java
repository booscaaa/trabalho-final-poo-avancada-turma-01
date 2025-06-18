package br.com.cesurgmarau.trabalho_final.core.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DeepSeekRequest {

    @JsonProperty("model")
    private String modelo;

    @JsonProperty("messages")
    private List<Message> mensagens;

    public static class Message {

        @JsonProperty("role")
        private String regra;

        @JsonProperty("content")
        private String conteudo;

        public String getRegra() {
            return regra;
        }

        public void setRegra(String regra) {
            this.regra = regra;
        }

        public String getConteudo() {
            return conteudo;
        }

        public void setConteudo(String conteudo) {
            this.conteudo = conteudo;
        }
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public List<Message> getMensagens() {
        return mensagens;
    }

    public void setMensagens(List<Message> mensagens) {
        this.mensagens = mensagens;
    }
}
