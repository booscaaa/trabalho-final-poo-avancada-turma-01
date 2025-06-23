package br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio;

import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioComentarioDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioProdutoDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioUsuarioDTO;

import java.util.List;

public interface RelatorioRepository {
    List<RelatorioComentarioDTO> totalComentariosPorSentimento();
    List<RelatorioProdutoDTO> mediaSentimentoPorProduto();
    List<RelatorioUsuarioDTO> rankingUsuariosMaisAtivos();
}