package br.com.cesurgmarau.trabalho_final.core.dto;

public class RelatorioProdutoResponse {
    private Integer produtoId;
    private Double mediaPontuacao;

    public RelatorioProdutoResponse(Integer produtoId, Double mediaPontuacao) {
        this.produtoId = produtoId;
        this.mediaPontuacao = mediaPontuacao;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public Double getMediaPontuacao() {
        return mediaPontuacao;
    }
}
