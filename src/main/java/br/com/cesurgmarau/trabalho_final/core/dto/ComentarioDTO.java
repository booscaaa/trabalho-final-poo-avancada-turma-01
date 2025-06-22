package br.com.cesurgmarau.trabalho_final.core.dto;

public class ComentarioDTO{
    private int id;
    private int produtoId;
    private String comentario;
    private int sentimentoId;
    private int usuarioId;
    private String nomeUsuario;

    public ComentarioDTO(int id, int usuarioId, int produtoId, String comentario, int sentimentoId, String nome) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.produtoId = produtoId;
        this.comentario = comentario;
        this.sentimentoId = sentimentoId;
        this.nomeUsuario = nome;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getSentimentoId() {
        return sentimentoId;
    }

    public void setSentimentoId(int sentimentoId) {
        this.sentimentoId = sentimentoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }
}
