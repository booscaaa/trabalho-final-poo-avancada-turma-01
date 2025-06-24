package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioProdutoResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioSentimentosResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioUsuarioResponse;

import java.util.List;

public interface RelatorioUsecase {
    List<RelatorioSentimentosResponse> totalComentariosPorSentimento();
    List<RelatorioProdutoResponse> mediaSentimentoPorProduto();
    List<RelatorioUsuarioResponse> rankingUsuariosMaisAtivos();
}
