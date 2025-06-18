package br.com.cesurgmarau.trabalho_final.infra.controller.usuario;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorios.RelatoriosUsuario.RelatoriosUsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.dto.MediaSentimentoProdutoOutput.MediaSentimentoProdutoOutput;
import br.com.cesurgmarau.trabalho_final.core.dto.RankingUsuarioOutput.RankingUsuarioOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RelatoriosUsuarioController {

    @Autowired
    RelatoriosUsuarioUseCase relatoriosUsuarioUseCase;

    @GetMapping("/relatorios/usuarios")
    public ResponseEntity<?> rankingAtividadeUsuarios () throws Exception {
        try {
            List<RankingUsuarioOutput> rankingAtividadeUsuarios = relatoriosUsuarioUseCase.rankingAtividadeUsuarios();
            return ResponseEntity.ok(rankingAtividadeUsuarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar o relatório! " + e.getMessage());
        }

    }

}
