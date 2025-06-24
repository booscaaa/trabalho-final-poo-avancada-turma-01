package br.com.cesurgmarau.trabalho_final.core.domain.contract.gateway;

public interface AIGateway {
    String enviarMensagem(String mensagem);
    int classificarComentario(String texto);
}
