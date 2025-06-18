package br.com.cesurgmarau.trabalho_final.infra.controller.comentario;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.buscaFiltrada.ComentarioFiltradoUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ComentarioFiltradoController {

    @Autowired
    ComentarioFiltradoUseCase comentarioFiltradoUseCase;


    @GetMapping("/comentarios?{idProduto}")
    public ResponseEntity<?> filtraPorProduto (@PathVariable int idProduto) throws Exception {
        try {
            List<Comentario> comentarios = comentarioFiltradoUseCase.filtraPorProduto(idProduto);
            return ResponseEntity.ok(comentarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar os comentarios! " + e.getMessage());
        }

    }

    @GetMapping("/comentarios?{idUsuario}")
    public ResponseEntity<?> filtraPorUsuario (@PathVariable int idUsuario) throws Exception {
        try {
            List<Comentario> comentarios = comentarioFiltradoUseCase.filtraPorUsuario(idUsuario);
            return ResponseEntity.ok(comentarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar os comentarios! " + e.getMessage());
        }

    }

    @GetMapping("/comentarios?{sentimento}")
    public ResponseEntity<?> filtraPorSentimento (@PathVariable String sentimento) throws Exception {
        try {
            List<Comentario> comentarios = comentarioFiltradoUseCase.filtraPorSentimento(sentimento);
            return ResponseEntity.ok(comentarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar os comentarios! " + e.getMessage());
        }

    }


}
