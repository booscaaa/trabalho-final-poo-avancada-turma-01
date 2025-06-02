package br.com.cesurgmarau.trabalho_final.Core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "comments")
public class Comentarios {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name="produto_id")
    private int produtoId;

    @Column(name="usuario_id")
    private int usuarioId;

    @Column(name="comentario")
    private String comentario;

    @Column(name="avaliacao")
    private int avaliacao;

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
