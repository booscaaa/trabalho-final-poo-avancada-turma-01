package br.com.cesurgmarau.trabalho_final.core.dto.request;

import jakarta.validation.constraints.NotNull;

public class UsuarioRequestDTO {

    @NotNull(message = "O campo 'nome' é obrigatório.")
    private String nome;

    @NotNull(message = "O campo 'senha' é obrigatório.")
    private String senha;

    @NotNull(message = "O campo 'email' é obrigatório.")
    private String email;

    public UsuarioRequestDTO(String nome, String senha, String email) {
        this.nome = nome;
        this.senha = senha;
        this.email = email;
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
