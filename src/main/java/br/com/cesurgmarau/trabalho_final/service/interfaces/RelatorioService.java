package br.com.cesurgmarau.trabalho_final.service.interfaces;

import br.com.cesurgmarau.trabalho_final.dto.RelatorioSentimentoDTO;
import br.com.cesurgmarau.trabalho_final.dto.RelatorioProdutoDTO;
import br.com.cesurgmarau.trabalho_final.dto.RelatorioUsuarioDTO;

import java.util.List;

public interface RelatorioService {

    List<RelatorioSentimentoDTO> totalComentariosPorSentimento();

    List<RelatorioProdutoDTO> mediaSentimentoPorProduto();

    List<RelatorioUsuarioDTO> rankingUsuariosMaisAtivos();
}
