package br.com.cesurgmarau.trabalho_final.core.domain.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorio.RelatorioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorio.RelatorioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.RelatorioSentimentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioUseCaseImpl implements RelatorioUseCase {
    @Autowired
    RelatorioRepository relatorioSentimentoRepository;

    @Override
    public List<RelatorioSentimentoDTO> relatorioSentimento() {
        return relatorioSentimentoRepository.relatorioSentimento();
    }
}
