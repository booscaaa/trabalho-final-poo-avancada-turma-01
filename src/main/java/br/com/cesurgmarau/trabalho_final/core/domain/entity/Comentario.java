package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
@Entity(name = "comentario")
public class Comentario {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "usuario_id")
    private int usuarioId;
    @Column(name = "livro_id")
    private int livroId;
    @Column(name = "conteudo")
    private String conteudo;
    @Column(name = "sentimento")
    private String sentimento;
    @Column(name = "data")
    private LocalDateTime data;

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
