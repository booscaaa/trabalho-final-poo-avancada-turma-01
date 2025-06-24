package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.controller.RelatorioController;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase.RelatorioUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class RelatorioControllerImpl implements RelatorioController {

    @Autowired
    private RelatorioUseCase relatorioUseCase;

    @GetMapping("/relatorio/sentimentos")
    public ResponseEntity<Map<Integer, Long>> totalPorSentimento() {
        Map<Integer, Long> resultado = relatorioUseCase.totalComentariosPorSentimento();
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/relatorio/produtos")
    public ResponseEntity<Map<Integer, Double>> mediaSentimentoPorProduto() {
        Map<Integer, Double> resultado = relatorioUseCase.mediaSentimentoPorProduto();
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/relatorio/usuarios")
    public ResponseEntity<List<Map<String, Object>>> rankingUsuariosMaisAtivos() {
        List<Map<String, Object>> resultado = relatorioUseCase.rankingUsuariosMaisAtivos();
        return ResponseEntity.ok(resultado);
    }
}
