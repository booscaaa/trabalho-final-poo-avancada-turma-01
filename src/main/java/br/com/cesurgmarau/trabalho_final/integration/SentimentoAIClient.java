package br.com.cesurgmarau.trabalho_final.integration;

public interface SentimentoAIClient {
    /**
     * Envia texto para análise de sentimento e retorna o sentimento identificado.
     * @param texto Texto a ser analisado.
     * @return Sentimento como string (ex: "Positivo", "Negativo", etc).
     */
    String analisarSentimento(String texto);
}
