package br.com.cesurgmarau.trabalho_final.core.dto.MediaSentimentoProdutoOutput;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

public class MediaSentimentoProdutoOutput {

    private String produto;

    private String sentimento_medio;

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getSentimento_medio() {
        return sentimento_medio;
    }

    public void setSentimento_medio(String sentimento_medio) {
        this.sentimento_medio = sentimento_medio;
    }

    public MediaSentimentoProdutoOutput(String produto, String sentimento_medio) {
        this.produto = produto;
        this.sentimento_medio = sentimento_medio;
    }
}
