package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.SentimentAnalyzer;

public class AvaliarComentarioUseCaseImpl {
    private final SentimentAnalyzer analyzer;

    public AvaliarComentarioUseCaseImpl(SentimentAnalyzer analyzer) {
        this.analyzer = analyzer;
    }

    public String executar(String comentario) {
        return analyzer.analisarComentario(comentario);
    }
}
