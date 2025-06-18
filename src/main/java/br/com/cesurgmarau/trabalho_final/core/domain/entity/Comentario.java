package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "comentarios")
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "texto")
    private String texto;

    @Column(name = "sentimento")
    private String sentimento;

    @Column(name = "id_usuario")
    private int id_usuario;

    @Column(name = "id_produto")
    private int id_produto;

    public Comentario() {
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTexto(){
        return texto;
    }
    public void setTexto(String texto){
        this.texto = texto;
    }
    public String getSentimento(){
        return sentimento;
    }
    public void setSentimento(String sentimento){
        this.sentimento = sentimento;
    }

    public int getId_produto() {
        return id_produto;
    }
    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public int getId_usuario() {
        return id_usuario;
    }
    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }
}