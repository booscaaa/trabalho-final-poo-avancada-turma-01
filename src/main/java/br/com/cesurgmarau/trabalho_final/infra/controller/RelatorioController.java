package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.dto.RelatorioDTO;
import br.com.cesurgmarau.trabalho_final.service.RelatorioService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class RelatorioController {

    private final RelatorioService relatorioService;

    public RelatorioController(RelatorioService relatorioServico) {
        this.relatorioService = relatorioServico;
    }

    @GetMapping
    public RelatorioDTO gerarRelatorio() {
        return relatorioService.gerarRelatorio();
    }
}

