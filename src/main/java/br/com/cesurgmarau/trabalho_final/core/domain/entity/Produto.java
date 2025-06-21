package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "produtos")
@JsonPropertyOrder({"id", "nome", "preco", "descricao"})
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_produto")
    private int produto_id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "preco", precision = 6, scale = 2, nullable = false)
    private BigDecimal preco;

    @Column(name = "descricao", nullable = true)
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
