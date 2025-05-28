package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Sentimento;

public interface SentimentoRepository {
    public Sentimento pegarSentimentoId(String sentimento);
    public void atualizarSentimento(int id, Sentimento sentimento);
}
