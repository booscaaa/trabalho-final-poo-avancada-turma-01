package br.com.cesurgmarau.trabalho_final.core.domain.entity;

import java.util.Map;

public class Sentimento {
    private String sentimento;

    public Sentimento(String sentimento) {
        this.sentimento = sentimento;
    }

    public String getSentimento() {
        return sentimento;
    }

    public void setSentimento(String sentimento) {
        this.sentimento = sentimento;
    }

    private static final Map<String, Integer> sentimentoParaNumero = Map.of(
            "Muito Positivo", 5,
            "Positivo", 4,
            "Neutro", 3,
            "Negativo", 2,
            "Muito Negativo", 1
    );

    public static Integer getNumeroSentimento(String sentimento) {
        return sentimentoParaNumero.get(sentimento);
    }

    private static final Map<Integer, String> numeroParaSentimento = Map.of(
            5, "Muito Positivo",
            4, "Positivo",
            3, "Neutro",
            2, "Negativo",
            1, "Muito Negativo"
    );

    public static String getSentimentoPorNumero(Integer numero) {
        return numeroParaSentimento.get(numero);
    }
}
