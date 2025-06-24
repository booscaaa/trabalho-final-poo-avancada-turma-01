package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Sentimento.SentimentoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Sentimento.SentimentoUsecase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Sentimentos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SentimentosUsecaseIMPL implements SentimentoUsecase {

    @Autowired
    SentimentoRepository sentimentoRepository;

    @Override
    public void cadastrarSentimento(Sentimentos sentimentos) {
        sentimentoRepository.cadastrarSentimento(sentimentos);
    }

    @Override
    public List<Sentimentos> listarSentimento() {
        return sentimentoRepository.listarSentimento();
    }

    @Override
    public Sentimentos getId(Long id) {
        return sentimentoRepository.getId(id);
    }

    @Override
    public void atualizarSentimento(Sentimentos sentimentos, Long id) {
        sentimentoRepository.atualizarSentimento(sentimentos, id);
    }

    @Override
    public void deletaSentimento(Long id) {
        sentimentoRepository.deletaSentimento(id);
    }
}
