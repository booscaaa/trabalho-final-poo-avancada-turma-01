package br.com.cesurgmarau.trabalho_final.infra.exceptions;

public class MensagemResponse {
    private String mensagem;

    public MensagemResponse(String mensagem){
        this.mensagem = mensagem;
    }

    public String getMensagem() {
        return mensagem;
    }
}
