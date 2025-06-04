package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import java.time.LocalDateTime;

public class Comentario {
    private int id;
    private String texto;
    private Usuario usuario;
    private Produto produto;
    private int sentimento;
    private LocalDateTime data;

    public Comentario(int id, String texto, Usuario usuario, Produto produto, int sentimento, LocalDateTime data) {
        this.id = id;
        this.texto = texto;
        this.usuario = usuario;
        this.produto = produto;
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

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
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
