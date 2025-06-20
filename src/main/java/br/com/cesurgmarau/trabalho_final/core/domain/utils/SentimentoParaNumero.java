package br.com.cesurgmarau.trabalho_final.core.domain.utils;

public class SentimentoParaNumero {
    public static int sentimentoParaNota(String sentimentoTexto){
        if (sentimentoTexto == null || sentimentoTexto.isBlank()) return 0;

        String[] linhas = sentimentoTexto.split("\\n");

        if (linhas.length == 0) return 0;

        String linhaSentimento = linhas[0].replace("*", "").trim().toLowerCase();

        return switch (linhaSentimento) {
            case "muito positivo" -> 5;
            case "positivo" -> 4;
            case "neutro" -> 3;
            case "negativo" -> 2;
            case "muito negativo" -> 1;
            default -> 0;
        };
    }
}
