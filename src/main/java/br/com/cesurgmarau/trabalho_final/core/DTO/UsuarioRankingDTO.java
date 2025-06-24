package br.com.cesurgmarau.trabalho_final.core.DTO;

public class UsuarioRankingDTO {
    private String nome;
    private Long totalComentarios;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getTotalComentarios() {
        return totalComentarios;
    }

    public void setTotalComentarios(Long totalComentarios) {
        this.totalComentarios = totalComentarios;
    }
}
