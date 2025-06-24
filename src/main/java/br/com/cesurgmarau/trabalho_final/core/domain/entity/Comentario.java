package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity(name = "comentario")
public class Comentario {
    @Id
    @Column(name = "id")
    private Integer id;
    @Column (name = "texto")
    private String texto;
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    @Column (name = "sentimento")
    private Integer sentimento;
    @Column (name = "data")
    private LocalDateTime data;

    public Comentario(Integer id, String texto, Usuario usuario, Produto produto, Integer sentimento, LocalDateTime data) {
        this.id = id;
        this.texto = texto;
        this.usuario = usuario;
        this.produto = produto;
        this.sentimento = sentimento;
        this.data = data;
    }

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

    public Integer getSentimento() {
        return sentimento;
    }

    public void setSentimento(Integer sentimento) {
        this.sentimento = sentimento;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }
}
