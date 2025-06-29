package br.com.cesurgmarau.trabalho_final.core.domain.dto;

public record ComentarioDTO(
        int id,
        String texto,
        String sentimento,
        String nome,
        String produto
) {
    public ComentarioDTO(int id, String texto, String sentimento, String nome, String produto) {
        this.id = id;
        this.texto = texto;
        this.sentimento = sentimento;
        this.nome = nome;
        this.produto = produto;
    }
}
