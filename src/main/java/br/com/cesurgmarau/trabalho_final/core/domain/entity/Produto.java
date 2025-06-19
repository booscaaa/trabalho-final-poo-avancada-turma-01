package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import br.com.cesurgmarau.trabalho_final.core.domain.enums.Unidade;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "produto")
public class Produto {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "valor_unitario")
    private Integer valorUnitario;
    @Enumerated(EnumType.STRING)
    @Column(name = "unidade")
    private Unidade unidade;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "quantidade")
    private Integer quantidade;
    @Column(name = "data")
    private LocalDateTime data;

    public Produto() {

    }
    public Produto(Integer id, String nome, Integer valorUnitario, Unidade unidade, String descricao, Integer quantidade, LocalDateTime data) {
        this.id = id;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.unidade = unidade;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.data = data;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Integer valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Unidade getUnidade() {
        return unidade;
    }

    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
