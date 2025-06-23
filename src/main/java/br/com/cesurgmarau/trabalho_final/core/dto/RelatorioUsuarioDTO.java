package br.com.cesurgmarau.trabalho_final.core.dto;

public class RelatorioUsuarioDTO {
    private int usuarioId;
    private String nome;
    private long totalComentarios;

    public RelatorioUsuarioDTO(int usuarioId, String nome, long totalComentarios) {
        this.usuarioId = usuarioId;
        this.nome = nome;
        this.totalComentarios = totalComentarios;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public String getNome() {
        return nome;
    }

    public long getTotalComentarios() {
        return totalComentarios;
    }
}