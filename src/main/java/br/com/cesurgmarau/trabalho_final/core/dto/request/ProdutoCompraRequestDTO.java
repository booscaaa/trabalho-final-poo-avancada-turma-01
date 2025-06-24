package br.com.cesurgmarau.trabalho_final.core.dto.request;

public class ProdutoCompraRequestDTO {
    private Integer produtoId;
    private Integer quantidade;

    public ProdutoCompraRequestDTO(Integer produtoId, Integer quantidade) {
        this.produtoId = produtoId;
        this.quantidade = quantidade;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
