package br.com.cesurgmarau.trabalho_final.core.dto.request;

import jakarta.validation.constraints.NotNull;

public class ProdutoRequestDTO {

    @NotNull(message = "O campo 'nome' é obrigatório.")
    private String nome;

    @NotNull(message = "O campo 'valor unitario' é obrigatório.")
    private Integer valorUnitario;

    @NotNull(message = "O campo 'unidade' é obrigatório.")
    private Integer unidade;

    private String descricao;

    @NotNull(message = "O campo 'quantidade' é obrigatório.")
    private Integer quantidade;

    public ProdutoRequestDTO(String nome, Integer valorUnitario, Integer unidade, String descricao, Integer quantidade) {
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.unidade = unidade;
        this.descricao = descricao;
        this.quantidade = quantidade;
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
}
