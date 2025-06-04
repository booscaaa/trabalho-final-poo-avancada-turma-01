package br.com.cesurgmarau.trabalho_final.core.domain.entity;

public class ProdutoCompra {
    private Compra compra;
    private Produto produto;
    private int quantidade;

    public ProdutoCompra(Compra compra, Produto produto, int quantidade) {
        this.compra = compra;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
