package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "cpf")
    private String cpf;
    @Column(name = "nome")
    private String nome;
    @Column(name = "quantidade_comentario")
    private int quantidadeComentario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setName(String nome) {
        this.nome = nome;
    }

    public int getQuantidadeComentario() {
        return quantidadeComentario;
    }

    public void setQuantidadeComentario(int quantidadeComentario) {
        this.quantidadeComentario = quantidadeComentario;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
