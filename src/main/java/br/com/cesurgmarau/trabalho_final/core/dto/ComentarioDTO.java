package br.com.cesurgmarau.trabalho_final.core.dto;

import java.time.LocalDateTime;

public class ComentarioDTO {
    private int id;
    private int usuarioId;
    private int livroId;
    private String conteudo;
    private String sentimento;
    private LocalDateTime data;

    public ComentarioDTO() {}

    public ComentarioDTO(int id, int usuarioId, int livroId, String conteudo, String sentimento, LocalDateTime data) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.livroId = livroId;
        this.conteudo = conteudo;
        this.sentimento = sentimento;
        this.data = data;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }
    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getLivroId() {
        return livroId;
    }
    public void setLivroId(int livroId) {
        this.livroId = livroId;
    }

    public String getConteudo() {
        return conteudo;
    }
    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getSentimento() {
        return sentimento;
    }
    public void setSentimento(String sentimento) {
        this.sentimento = sentimento;
    }

    public LocalDateTime getData() {
        return data;
    }
    public void setData(LocalDateTime data) {
        this.data = data;
    }
}


