package br.com.cesurgmarau.trabalho_final.core.dto.response;

public class ProdutoCompraResponseDTO {
    private int produtoId;
    private String nomeProduto;
    private int quantidade;

    public ProdutoCompraResponseDTO(int produtoId, String nomeProduto, int quantidade) {
        this.produtoId = produtoId;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
