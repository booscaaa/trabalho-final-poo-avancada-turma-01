package br.com.cesurgmarau.trabalho_final.core.util;

public class SentimentoUtils {

    public static int converterSentimentoParaPontuacao(String sentimento) {
        if (sentimento == null) {
            return 3;
        }
        return switch (sentimento.toLowerCase()) {
            case "muito negativo" -> 1;
            case "negativo" -> 2;
            case "neutro" -> 3;
            case "positivo" -> 4;
            case "muito positivo" -> 5;
            default -> 3;
        };
    }
}
