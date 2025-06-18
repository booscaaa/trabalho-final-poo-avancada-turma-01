package br.com.cesurgmarau.trabalho_final.infra.controller.comentario;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorios.RelatoriosComentario.RelatorioComentUseCase;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentariosPorSentimentoOutput.ComentarioPorSentimentoOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RelatoriosComentarioController {

    @Autowired
    RelatorioComentUseCase relatorioComentUseCase;

    @GetMapping("/relatorios/sentimentos")
    public ResponseEntity<?> listaTotalComentariosPorSentimento () throws Exception {
        try {
            List<ComentarioPorSentimentoOutput> comentarios = relatorioComentUseCase.listaTotalComentariosPorSentimento();
            return ResponseEntity.ok(comentarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar o relatório! " + e.getMessage());
        }

    }
}
