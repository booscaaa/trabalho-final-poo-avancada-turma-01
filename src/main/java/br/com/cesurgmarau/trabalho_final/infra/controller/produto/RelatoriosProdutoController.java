package br.com.cesurgmarau.trabalho_final.infra.controller.produto;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorios.RelatoriosProduto.RelatoriosProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentariosPorSentimentoOutput.ComentarioPorSentimentoOutput;
import br.com.cesurgmarau.trabalho_final.core.dto.MediaSentimentoProdutoOutput.MediaSentimentoProdutoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RelatoriosProdutoController {

    @Autowired
    RelatoriosProdutoUseCase relatoriosProdutoUseCase;

    @GetMapping("/relatorios/produtos")
    public ResponseEntity<?> mediaDeSentimentoPorProduto () throws Exception {
        try {
            List<MediaSentimentoProdutoOutput> mediaSentimento = relatoriosProdutoUseCase.mediaDeSentimentoPorProduto();
            return ResponseEntity.ok(mediaSentimento);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar o relatório! " + e.getMessage());
        }

    }

}
