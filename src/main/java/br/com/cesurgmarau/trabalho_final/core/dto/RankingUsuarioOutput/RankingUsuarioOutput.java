package br.com.cesurgmarau.trabalho_final.core.dto.RankingUsuarioOutput;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;

public class RankingUsuarioOutput {

    private int posicao;

    private String usuario;

    private int quantidade_comentarios;

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getQuantidade_comentarios() {
        return quantidade_comentarios;
    }

    public void setQuantidade_comentarios(int quantidade_comentarios) {
        this.quantidade_comentarios = quantidade_comentarios;
    }

    public RankingUsuarioOutput(int posicao, String usuario, int quantidade_comentarios) {
        this.posicao = posicao;
        this.usuario = usuario;
        this.quantidade_comentarios = quantidade_comentarios;
    }
}
