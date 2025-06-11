package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.CategoriaUseCase;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "produto")
public class Produto {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "pontuacao")
    private int pontuacao;
    @Column(name= "categoria_id")
    private int categoriaId;
    @Column(name= "quantidade_comentario")
    private int quantidadeComentaario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getCategoriaId() {
        return categoriaId;
    }
    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getQuantidadeComentaario() {
        return quantidadeComentaario;
    }

    public void setQuantidadeComentaario(int quantidadeComentaario) {
        this.quantidadeComentaario = quantidadeComentaario;
    }
}
