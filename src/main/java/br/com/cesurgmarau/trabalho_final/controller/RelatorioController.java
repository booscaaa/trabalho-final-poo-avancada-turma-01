package br.com.cesurgmarau.trabalho_final.controller;

import br.com.cesurgmarau.trabalho_final.service.interfaces.RelatorioService;
import br.com.cesurgmarau.trabalho_final.dto.RelatorioSentimentoDTO;
import br.com.cesurgmarau.trabalho_final.dto.RelatorioProdutoDTO;
import br.com.cesurgmarau.trabalho_final.dto.RelatorioUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private RelatorioService service;

    @GetMapping("/sentimentos")
    public List<RelatorioSentimentoDTO> totalComentariosPorSentimento() {
        return service.totalComentariosPorSentimento();
    }

    @GetMapping("/produtos")
    public List<RelatorioProdutoDTO> mediaSentimentoPorProduto() {
        return service.mediaSentimentoPorProduto();
    }

    @GetMapping("/usuarios")
    public List<RelatorioUsuarioDTO> rankingUsuariosMaisAtivos() {
        return service.rankingUsuariosMaisAtivos();
    }
}
