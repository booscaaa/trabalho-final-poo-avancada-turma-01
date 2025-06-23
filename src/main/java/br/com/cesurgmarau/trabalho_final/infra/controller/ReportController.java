package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ReportUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ReportController {

    private final ReportUseCase reportUseCase;

    public ReportController(ReportUseCase reportUseCase) {
        this.reportUseCase = reportUseCase;
    }

    @GetMapping("/report/feeling/{id}")
    public ResponseEntity<Map<String, Object>> getTotalByFeelingId(@PathVariable int id) {
        Map<String, Object> result = reportUseCase.getCommentCountByFeelingId(id);
        if (result.isEmpty()) {
            Map<String, Object> mensagem = new HashMap<>();
            mensagem.put("mensagem", "Não existe nenhum comentário com esse sentimento.");
            return ResponseEntity.status(404).body(mensagem);
        }
        return ResponseEntity.ok(result);
    }

    @GetMapping("/report/product/{id}")
    public ResponseEntity<Map<String, Object>> getAverageByProductId(@PathVariable int id) {
        Map<String, Object> result = reportUseCase.getAverageFeelingByProductId(id);

        if (result.containsKey("mensagem")) {
            return ResponseEntity.status(404).body(result);
        }

        return ResponseEntity.ok(result);
    }


    @GetMapping("/report/user")
    public List<Map<String, Object>> getUserRanking() {
        return reportUseCase.getUserRanking();
    }
}

