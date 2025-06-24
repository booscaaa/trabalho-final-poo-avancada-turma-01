package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "usuario")
public class Usuario {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "senha")
    private String senha;
    @Column(name = "email")
    private String email;

    public Usuario() {

    }

    public Usuario(Integer id, String nome, String senha, String email) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
