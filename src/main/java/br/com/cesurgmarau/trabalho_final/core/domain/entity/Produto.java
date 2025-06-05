package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "produtos")
@JsonPropertyOrder({"id", "nome", "preco", "descricao"})
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int produto_id;
    private String nome;
    @Column(precision = 6, scale = 2)
    private BigDecimal preco;
    private String descricao;

    public int getId() {
        return produto_id;
    }

    public void setId(int id) {
        this.produto_id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
