package br.com.cesurgmarau.trabalho_final.core.dto.ComentariosPorSentimentoOutput;

import jakarta.persistence.*;

public class ComentarioPorSentimentoOutput {

    private String sentimento;

    private int quantidade_comentarios;

    public String getSentimento() {
        return sentimento;
    }

    public void setSentimento(String sentimento) {
        this.sentimento = sentimento;
    }

    public int getQuantidade_comentarios() {
        return quantidade_comentarios;
    }

    public void setQuantidade_comentarios(int quantidade_comentarios) {
        this.quantidade_comentarios = quantidade_comentarios;
    }

    public ComentarioPorSentimentoOutput(String sentimento, int quantidade_comentarios) {
        this.sentimento = sentimento;
        this.quantidade_comentarios = quantidade_comentarios;
    }

}
