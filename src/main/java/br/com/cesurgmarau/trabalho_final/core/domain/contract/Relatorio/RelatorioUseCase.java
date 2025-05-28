package br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorio;

import br.com.cesurgmarau.trabalho_final.core.domain.dto.RelatorioSentimentoDTO;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Sentimento;

import java.util.List;

public interface RelatorioUseCase {
    public List<RelatorioSentimentoDTO> relatorioSentimento();
    public List<String> totalSentimentosByProduct(int id);
    public int calcularMediaSentimentos(int idProduto);
    public String classificaPorMedia(int media);
}
