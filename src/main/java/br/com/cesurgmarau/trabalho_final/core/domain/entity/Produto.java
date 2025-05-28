package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity (name ="produto")
public class Produto {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="nome")
    private String nome;

    @Column(name="descricao")
    private String descricao;

    @Column(name="preco")
    private double preco;

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome=nome;
    }
    public String getDescricao(){
        return descricao;
    }
    public void setDescricao(String descricao){
        this.descricao=descricao;
    }
    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco){
        this.preco=preco;
    }
}
