package br.com.cesurgmarau.trabalho_final.core.dto.response;

import java.time.LocalDateTime;

public class ProdutoResponseDTO {
    private Integer id;
    private String nome;
    private Integer valorUnitario;
    private Integer unidade;
    private String descricao;
    private Integer quantidade;
    private LocalDateTime data;

    public ProdutoResponseDTO(Integer id, String nome, Integer valorUnitario, Integer unidade, String descricao, Integer quantidade, LocalDateTime data) {
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

    public Integer getUnidade() {
        return unidade;
    }

    public void setUnidade(Integer unidade) {
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