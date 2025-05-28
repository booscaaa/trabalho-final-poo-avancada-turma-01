package br.com.cesurgmarau.trabalho_final.core.dto.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;

@Entity
@Table(name="comentario")
public class ComentarioRepositoryDto {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="texto", length=500, nullable=false)
    private String texto;

    @Column(name="usuario_id", nullable=false)
    private int usuarioId;

    @Column(name="produto_id", nullable=false)
    private int produtoId;

    @Column(name="sentimento")
    private int sentimento;

    @Column(name="data")
    private Date data;

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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
