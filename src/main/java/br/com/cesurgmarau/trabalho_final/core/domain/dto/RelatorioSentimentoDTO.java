package br.com.cesurgmarau.trabalho_final.core.domain.dto;

public record RelatorioSentimentoDTO(
        String sentimento,
        Long quantidade
) {
    public RelatorioSentimentoDTO(String sentimento, Long quantidade) {
        this.sentimento = sentimento;
        this.quantidade = quantidade;
    }
}
