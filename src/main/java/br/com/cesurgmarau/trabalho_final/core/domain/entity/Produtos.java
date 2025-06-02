package br.com.cesurgmarau.trabalho_final.Core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "products")
public class Produtos {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="name")
    private String name;

    @Column (name="price")
    private float price;

    @Column (name="descricao")
    private String descricao;

    @Column(name="avaliacao_produto")
    private Double avaliacaoProduto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getAvaliacaoProduto() {
        return avaliacaoProduto;
    }

    public void setAvaliacaoProduto(Double avaliacaoProduto) {
        this.avaliacaoProduto = avaliacaoProduto;
    }
}
