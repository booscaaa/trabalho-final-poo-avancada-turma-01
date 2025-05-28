package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorio.RelatorioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.RelatorioSentimentoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RelatorioController {
    @Autowired
    private RelatorioUseCase relatorioUseCase;

    @GetMapping("/relatorio/sentimento")
    public List<RelatorioSentimentoDTO> relatorioSentimento() {
        return relatorioUseCase.relatorioSentimento();
    }
}
