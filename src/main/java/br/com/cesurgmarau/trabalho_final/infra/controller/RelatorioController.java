package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.RelatorioUsecase;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioProdutoResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioSentimentosResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioUsuarioResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    private final RelatorioUsecase relatorioUsecase;

    public RelatorioController(RelatorioUsecase relatorioUsecase) {
        this.relatorioUsecase = relatorioUsecase;
    }

    @GetMapping("/sentimentos")
    public List<RelatorioSentimentosResponse> totalPorSentimento() {
        return relatorioUsecase.totalComentariosPorSentimento();
    }

    @GetMapping("/produtos")
    public List<RelatorioProdutoResponse> mediaPorProduto() {
        return relatorioUsecase.mediaSentimentoPorProduto();
    }

    @GetMapping("/usuarios")
    public List<RelatorioUsuarioResponse> rankingUsuarios() {
        return relatorioUsecase.rankingUsuariosMaisAtivos();
    }
}
