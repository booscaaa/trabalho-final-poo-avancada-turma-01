package br.com.cesurgmarau.trabalho_final.core.domain.entity;

public class Mensagem {
    private String regra;
    private String conteudo;

    public Mensagem(String regra, String conteudo) {
        this.regra = regra;
        this.conteudo = conteudo;
    }

    public String getRegra() {
        return regra;
    }

    public void setRegra(String regra) {
        this.regra = regra;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
