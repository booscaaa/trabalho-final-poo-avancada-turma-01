package br.com.cesurgmarau.trabalho_final.dto;

public class RelatorioSentimentoDTO {
    private String sentimento;
    private Long total;

    public String getSentimento() {
        return sentimento;
    }

    public void setSentimento(String sentimento) {
        this.sentimento = sentimento;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
