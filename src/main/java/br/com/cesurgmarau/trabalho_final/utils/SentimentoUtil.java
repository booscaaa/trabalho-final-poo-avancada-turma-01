package br.com.cesurgmarau.trabalho_final.utils;

public class SentimentoUtil {

    public static int paraValorNumerico(String sentimentoStr) {
        Sentimento sentimento = Sentimento.fromDescricao(sentimentoStr);
        return sentimento.getValor();
    }

    public static String paraDescricao(int valor) {
        for (Sentimento s : Sentimento.values()) {
            if (s.getValor() == valor) {
                return s.getDescricao();
            }
        }
        return "Desconhecido";
    }
}
