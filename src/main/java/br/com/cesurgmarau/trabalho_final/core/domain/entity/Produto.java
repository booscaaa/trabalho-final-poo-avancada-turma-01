package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity(name="produtos")
public class Produto {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="nome")
    private String nome;

    @Column (name="preco")
    private float preco;

    @Column (name="descricao")
    private String descricao;

    @Column(name="avaliacao_produto")
    private BigDecimal avaliacaoProduto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getAvaliacaoProduto() {
        return avaliacaoProduto;
    }

    public void setAvaliacaoProduto(BigDecimal avaliacaoProduto) {
        this.avaliacaoProduto = avaliacaoProduto;
    }
}
