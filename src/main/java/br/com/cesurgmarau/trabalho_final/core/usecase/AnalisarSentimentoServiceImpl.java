package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.UseCase.AnalisarSentimentoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalisarSentimentoServiceImpl implements AnalisarSentimentoUseCase {

    @Autowired
   AnalisarSentimentoUseCase analisarSentimentoUseCase;

    @Override
    public List<AnalisarSentimento> fetch() {
        return analisarSentimentoUseCase.fetch();
    }

    @Override
    public AnalisarSentimento fetchById(int id) {
        return analisarSentimentoUseCase.fetchById(id);
    }

    @Override
    public void createAnaliseDeSentimento(br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento analisarSentimento) {
        analisarSentimentoUseCase.createAnaliseDeSentimento(analisarSentimento);
    }

    @Override
    public void updateAnaliseDeSentimento(br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento analisarSentimento, int id) {
        analisarSentimentoUseCase.updateAnaliseDeSentimento(analisarSentimento, id);
    }

    @Override
    public void deleteAnaliseDeSentimento(int id) {
        analisarSentimentoUseCase.deleteAnaliseDeSentimento(id);
    }

}
