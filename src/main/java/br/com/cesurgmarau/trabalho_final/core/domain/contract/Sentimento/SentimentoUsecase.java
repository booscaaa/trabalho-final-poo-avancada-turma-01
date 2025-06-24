package br.com.cesurgmarau.trabalho_final.core.domain.contract.Sentimento;


import br.com.cesurgmarau.trabalho_final.core.domain.entity.Sentimentos;

import java.util.List;

public interface SentimentoUsecase {
    void cadastrarSentimento(Sentimentos sentimentos);
    List<Sentimentos> listarSentimento();
    Sentimentos getId(Long id);
    void atualizarSentimento(Sentimentos sentimentos, Long id);
    void deletaSentimento(Long id);
}