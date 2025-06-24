package br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase;

import java.util.List;
import java.util.Map;

public interface RelatorioUseCase {
    Map<Integer, Long> totalComentariosPorSentimento();

    Map<Integer, Double> mediaSentimentoPorProduto();

    List<Map<String, Object>> rankingUsuariosMaisAtivos();
}
