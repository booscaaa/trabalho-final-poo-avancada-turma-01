package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Sentimento;

public interface SentimentoRepository {
    public Sentimento pegarTipoSentimento(String sentimento);
    public Sentimento pegarSentimentoId(int id);
    public void atualizarSentimento(int id, Sentimento sentimento);
}
