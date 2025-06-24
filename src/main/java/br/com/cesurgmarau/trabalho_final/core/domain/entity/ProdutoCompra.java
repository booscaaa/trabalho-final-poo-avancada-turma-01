package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.*;

@Entity(name = "produto_compra")
public class ProdutoCompra {

    @EmbeddedId
    private ProdutoCompraId id;

    @ManyToOne
    @MapsId("compraId")
    @JoinColumn(name = "compra_id")
    private Compra compra;

    @ManyToOne
    @MapsId("produtoId")
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Column(name = "quantidade")
    private Integer quantidade;

    public ProdutoCompra(Compra compra, Produto produto, Integer quantidade) {
        this.compra = compra;
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public ProdutoCompra() {

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

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}
