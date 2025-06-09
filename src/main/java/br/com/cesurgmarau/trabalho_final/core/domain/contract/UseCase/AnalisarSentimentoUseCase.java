package br.com.cesurgmarau.trabalho_final.core.domain.contract.UseCase;

import java.util.List;

public interface AnalisarSentimentoUseCase {
    List<br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento> fetch ();
    br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento fetchById (int id);
    void createAnaliseDeSentimento (br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento analisarSentimento);
    void updateAnaliseDeSentimento (br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento analisarSentimento, int id);
    void deleteAnaliseDeSentimento (int id);
}
