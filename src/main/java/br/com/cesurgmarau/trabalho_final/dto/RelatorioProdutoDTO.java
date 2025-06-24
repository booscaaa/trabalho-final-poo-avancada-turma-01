package br.com.cesurgmarau.trabalho_final.dto;

public class RelatorioProdutoDTO {
    private Long produtoId;
    private String nomeProduto;
    private Double mediaSentimento;

    public Long getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Long produtoId) {
        this.produtoId = produtoId;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Double getMediaSentimento() {
        return mediaSentimento;
    }

    public void setMediaSentimento(Double mediaSentimento) {
        this.mediaSentimento = mediaSentimento;
    }
}