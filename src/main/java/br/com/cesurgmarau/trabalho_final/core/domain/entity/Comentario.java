package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "comentario")
public class Comentario {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "usuario_id")
    private int usuarioId;
    @Column(name = "produto_id")
    private int produtoId;
    @Column(name = "comentario")
    private String comentario;
    @Column(name = "sentimento_id")
    private int sentimentoId;

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
}
