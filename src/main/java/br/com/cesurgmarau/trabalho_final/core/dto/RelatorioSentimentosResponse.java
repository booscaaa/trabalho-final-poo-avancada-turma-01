package br.com.cesurgmarau.trabalho_final.core.dto;

public class RelatorioSentimentosResponse {
    private String sentimento;
    private Long quantidade;

    public RelatorioSentimentosResponse(String sentimento, Long quantidade) {
        this.sentimento = sentimento;
        this.quantidade = quantidade;
    }

    public String getSentimento() {
        return sentimento;
    }

    public Long getQuantidade() {
        return quantidade;
    }
}
