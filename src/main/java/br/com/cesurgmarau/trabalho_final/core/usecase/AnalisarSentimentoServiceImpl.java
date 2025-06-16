package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.UseCase.AnalisarSentimentoUseCase;
import br.com.cesurgmarau.trabalho_final.infra.repository.AnalisarSentimentoRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalisarSentimentoServiceImpl implements AnalisarSentimentoUseCase {

    @Autowired
    AnalisarSentimentoRepositoryImpl analisarSentimentoRepository;

    @Override
    public List<AnalisarSentimento> fetch() {
        return analisarSentimentoRepository.fetch();
    }

    @Override
    public AnalisarSentimento fetchById(int id) {
        return analisarSentimentoRepository.fetchById(id);
    }

    @Override
    public void createAnaliseDeSentimento(br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento analisarSentimento) {
        analisarSentimentoRepository.createAnaliseDeSentimento(analisarSentimento);
    }

    @Override
    public void updateAnaliseDeSentimento(br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento analisarSentimento, int id) {
        analisarSentimentoRepository.updateAnaliseDeSentimento(analisarSentimento, id);
    }

    @Override
    public void deleteAnaliseDeSentimento(int id) {
        analisarSentimentoRepository.deleteAnaliseDeSentimento(id);
    }

}
