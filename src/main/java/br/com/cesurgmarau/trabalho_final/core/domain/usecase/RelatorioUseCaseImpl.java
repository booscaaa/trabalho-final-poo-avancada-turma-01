package br.com.cesurgmarau.trabalho_final.core.domain.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorio.RelatorioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorio.RelatorioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.RelatorioSentimentoDTO;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Sentimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioUseCaseImpl implements RelatorioUseCase {
    @Autowired
    private RelatorioRepository relatorioSentimentoRepository;

    @Override
    public List<RelatorioSentimentoDTO> relatorioSentimento() {
        return relatorioSentimentoRepository.relatorioSentimento();
    }

    @Override
    public List<String> totalSentimentosByProduct(int id) {
        return relatorioSentimentoRepository.totalSentimentosByProduct(id);
    }

    @Override
    public int calcularMediaSentimentos(int idProduto) {
        List<String> sentimentos = relatorioSentimentoRepository.totalSentimentosByProduct(idProduto);
        double soma = 0.0;
        for (int i = 0; i < sentimentos.size(); i++) {
            Integer valor = Sentimento.getNumeroSentimento(sentimentos.get(i));
            soma += valor;
        }
        return (int) Math.round(soma/sentimentos.size());
    }

    @Override
    public String classificaPorMedia(int media) {
         return Sentimento.getSentimentoPorNumero(media);
    }
}
