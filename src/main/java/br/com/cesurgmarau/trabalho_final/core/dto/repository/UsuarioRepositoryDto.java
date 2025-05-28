package br.com.cesurgmarau.trabalho_final.core.dto.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="usuario")
public class UsuarioRepositoryDto {
    @Id
    @Column(name="id")
    private int id;

    @Column(name="nome", length=100, nullable=false)
    private String nome;

    @Column(name="senha", length=100, nullable=false)
    private String senha;

    @Column(name="email", length=100, nullable=false)
    private String email;

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
