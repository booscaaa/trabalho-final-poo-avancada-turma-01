package br.com.cesurgmarau.trabalho_final.core.util;

public class SentimentoMapper {

    public static int mapSentimentoToId(String sentimento_id) {
        return switch (sentimento_id.toLowerCase()) {
            case "muito negativo" -> 1;
            case "negativo" -> 2;
            case "neutro" -> 3;
            case "positivo" -> 4;
            case "muito positivo" -> 5;
            default -> 3;
        };
    }
}

