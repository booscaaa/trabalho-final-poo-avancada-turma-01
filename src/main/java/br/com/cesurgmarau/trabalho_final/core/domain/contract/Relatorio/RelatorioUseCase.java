package br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorio;

import br.com.cesurgmarau.trabalho_final.core.domain.dto.RelatorioSentimentoDTO;

import java.util.List;

public interface RelatorioUseCase {
    public List<RelatorioSentimentoDTO> relatorioSentimento();
}
