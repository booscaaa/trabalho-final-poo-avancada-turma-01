package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.*;

@Entity(name = "comentario")
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "usuario_id")
    private int usuarioId;
    @Column(name = "livro_id")
    private int livroId;
    @Column(name = "texto", nullable = false)
    private String texto;
    private double scoreSentimento;

    private String sentimento;

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

    public int getNotaSentimento() {
        switch (sentimento != null ? sentimento.toLowerCase() : "") {
            case "muito positivo": return 5;
            case "positivo": return 4;
            case "neutro": return 3;
            case "negativo": return 2;
            case "muito negativo": return 1;
            default: return 3;
        }
    }
}

