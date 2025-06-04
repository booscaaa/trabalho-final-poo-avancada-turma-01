package br.com.cesurgmarau.trabalho_final.core.dto.response;

import java.time.LocalDateTime;

public class ProdutoResponseDTO {
    private int id;
    private String nome;
    private int valorUnitario;
    private int unidade;
    private String descricao;
    private int quantidade;
    private LocalDateTime data;

    public ProdutoResponseDTO(int id, String nome, int valorUnitario, int unidade, String descricao, int quantidade, LocalDateTime data) {
        this.id = id;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.unidade = unidade;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.data = data;
    }

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

    public int getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(int valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getUnidade() {
        return unidade;
    }

    public void setUnidade(int unidade) {
        this.unidade = unidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}