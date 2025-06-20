package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

@Entity
@Table(name = "comentarios")
@JsonPropertyOrder({"id", "comentario", "sentimento", "usuario", "produto"})
public class Comentario {
    @Id
    @Column(name = "id_comentario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_comentario;

    @Column(name = "comentario", nullable = false)
    private String comentario;

    @Column(name = "sentimento")
    private String sentimento;

    @ManyToOne
    @JoinColumn(name = "usuario", referencedColumnName = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "produto", referencedColumnName = "produto_id")
    private Produto produto;

    @Column(name = "sentimento_nota")
    private Integer notaSentimento;

    public int getId() {
        return id_comentario;
    }

    public void setId(int id) {
        this.id_comentario = id;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getSentimento() {
        return sentimento;
    }

    public void setSentimento(String sentimento) {
        this.sentimento = sentimento;
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

    public Integer getNotaSentimento() {
        return notaSentimento;
    }

    public void setNotaSentimento(Integer notaSentimento) {
        this.notaSentimento = notaSentimento;
    }
}
