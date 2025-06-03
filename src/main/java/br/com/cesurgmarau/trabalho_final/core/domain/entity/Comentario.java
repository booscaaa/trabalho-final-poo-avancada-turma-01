package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;

@Entity
@Table(name = "comentarios")
public class Comentario {

    @Id
    private Integer id;

    @Column
    private String texto;

    private String sentimento;

    @Column(name = "usuario_id")
    private Integer usuarioId;

    @Column(name = "produto_id")
    private Integer produtoId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getSentimento() {
        return sentimento;
    }

    public void setSentimento(String sentimento) {
        this.sentimento = sentimento;
    }

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Integer getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }
}
