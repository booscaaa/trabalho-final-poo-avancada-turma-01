package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity (name = "produto")
public class Produto {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "nome_produto")
    private String nomeProduto;

    @Column(name = "descricao_produto")
    private String descricaoProduto;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }
}
