package br.com.cesurgmarau.trabalho_final.core.dto.response;

import java.time.LocalDateTime;

public class ComentarioResponseDTO {
    private int id;
    private String texto;
    private int usuarioId;
    private int produtoId;
    private int sentimento;
    private LocalDateTime data;

    public ComentarioResponseDTO(int id, String texto, int usuarioId, int produtoId, int sentimento, LocalDateTime data) {
        this.id = id;
        this.texto = texto;
        this.usuarioId = usuarioId;
        this.produtoId = produtoId;
        this.sentimento = sentimento;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getSentimento() {
        return sentimento;
    }

    public void setSentimento(int sentimento) {
        this.sentimento = sentimento;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
