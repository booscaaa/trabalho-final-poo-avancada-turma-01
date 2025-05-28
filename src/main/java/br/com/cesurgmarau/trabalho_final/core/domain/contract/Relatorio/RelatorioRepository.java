package br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorio;

import br.com.cesurgmarau.trabalho_final.core.domain.dto.RelatorioSentimentoDTO;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Sentimento;

import java.util.List;

public interface RelatorioRepository {
    public List<RelatorioSentimentoDTO> relatorioSentimento();
    public List<String> totalSentimentosByProduct(int id);
}
