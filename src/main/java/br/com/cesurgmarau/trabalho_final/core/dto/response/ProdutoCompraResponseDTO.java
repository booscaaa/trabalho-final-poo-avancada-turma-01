package br.com.cesurgmarau.trabalho_final.core.dto.response;

public class ProdutoCompraResponseDTO {
    private Integer produtoId;
    private String nomeProduto;
    private Integer quantidade;

    public ProdutoCompraResponseDTO(Integer produtoId, String nomeProduto, Integer quantidade) {
        this.produtoId = produtoId;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
