package br.com.cesurgmarau.trabalho_final.core.domain.entity;



import jakarta.persistence.*;

@Entity (name="comentario")
public class Comentario {

    @Id
    @Column(name="id")
    private int id;

    @Column(name="texto")
    private String texto;

    @Column(name="sentimento")
    private String sentimento;

    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name="id_produto")
    private Produto produto;


    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getTexto(){
        return texto;
    }
    public void setTexto(String texto){
        this.texto=texto;
    }
    public String getSentimento(){
        return sentimento;
    }
    public void setSentimento(String sentimento){
        this.sentimento=sentimento;
    }
    public Usuario getUsuario(){
        return usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario=usuario;
    }
    public Produto getProduto(){
        return produto;
    }
    public void setProduto(Produto produto){
        this.produto = produto;
    }
}
