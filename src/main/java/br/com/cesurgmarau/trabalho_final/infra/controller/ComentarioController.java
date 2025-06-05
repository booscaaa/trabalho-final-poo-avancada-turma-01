package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioRequest;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioResponse;
import br.com.cesurgmarau.trabalho_final.core.usecase.ComentarioUsecase;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioUsecase comentarioUsecase;

    public ComentarioController(ComentarioUsecase comentarioUsecase) {
        this.comentarioUsecase = comentarioUsecase;
    }

    @PostMapping
    public ResponseEntity<ComentarioResponse> criar(@RequestBody ComentarioRequest request) {
        ComentarioResponse response = comentarioUsecase.criar(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ComentarioResponse> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(comentarioUsecase.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<ComentarioResponse>> buscar(
            @RequestParam(required = false) Integer produtoId,
            @RequestParam(required = false) Integer usuarioId,
            @RequestParam(required = false) String sentimento
    ) {
        if (produtoId != null) {
            return ResponseEntity.ok(comentarioUsecase.buscarPorProdutoId(produtoId));
        } else if (usuarioId != null) {
            return ResponseEntity.ok(comentarioUsecase.buscarPorUsuarioId(usuarioId));
        } else if (sentimento != null) {
            return ResponseEntity.ok(comentarioUsecase.buscarPorSentimento(sentimento));
        } else {
            return ResponseEntity.ok(comentarioUsecase.listarTodos());
        }
    }
}
