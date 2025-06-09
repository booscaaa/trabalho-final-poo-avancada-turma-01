package br.com.cesurgmarau.trabalho_final.core.domain.contract.Repository;

import java.util.List;

public interface AnalisarSentimentoRepository {
    List<br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento> fetch ();
    br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento fetchById (int id);
    void createAnaliseDeSentimento (br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento analisarSentimento);
    void updateAnaliseDeSentimento (br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento analisarSentimento, int id);
    void deleteAnaliseDeSentimento (int id);
}
