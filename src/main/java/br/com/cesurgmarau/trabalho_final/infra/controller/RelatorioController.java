package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio.RelatorioUseCase;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioComentarioDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioProdutoDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioUseCase relatorioUseCase;

    // 1. Total de comentários por sentimento
    @GetMapping("/sentimentos")
    public List<RelatorioComentarioDTO> totalComentariosPorSentimento() {
        return relatorioUseCase.totalComentariosPorSentimento();
    }

    // 2. Média de sentimento por produto
    @GetMapping("/produtos")
    public List<RelatorioProdutoDTO> mediaSentimentoPorProduto() {
        return relatorioUseCase.mediaSentimentoPorProduto();
    }

    // 3. Ranking de usuários mais ativos
    @GetMapping("/usuarios")
    public List<RelatorioUsuarioDTO> rankingUsuariosMaisAtivos() {
        return relatorioUseCase.rankingUsuariosMaisAtivos();
    }
}