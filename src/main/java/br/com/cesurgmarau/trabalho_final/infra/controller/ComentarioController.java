package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioRequest;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioResponse;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioUsecase;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
        ComentarioResponse comentario = comentarioUsecase.buscarPorId(id);
        if (comentario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comentário não encontrado");
        }
        return ResponseEntity.ok(comentario);
    }

    @GetMapping
    public ResponseEntity<List<ComentarioResponse>> listarTodos() {
        List<ComentarioResponse> comentarios = comentarioUsecase.listarTodos();
        return ResponseEntity.ok(comentarios);
    }

    @GetMapping("/produto/{produtoId}")
    public ResponseEntity<List<ComentarioResponse>> buscarPorProduto(@PathVariable Integer produtoId) {
        List<ComentarioResponse> comentarios = comentarioUsecase.buscarPorProdutoId(produtoId);
        return ResponseEntity.ok(comentarios);
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<List<ComentarioResponse>> buscarPorUsuario(@PathVariable Integer usuarioId) {
        List<ComentarioResponse> comentarios = comentarioUsecase.buscarPorUsuarioId(usuarioId);
        return ResponseEntity.ok(comentarios);
    }

    @GetMapping("/sentimento/{sentimento}")
    public ResponseEntity<List<ComentarioResponse>> buscarPorSentimento(@PathVariable String sentimento) {
        List<ComentarioResponse> comentarios = comentarioUsecase.buscarPorSentimento(sentimento);
        return ResponseEntity.ok(comentarios);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        ComentarioResponse comentario = comentarioUsecase.buscarPorId(id);
        if (comentario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comentário não encontrado");
        }
        comentarioUsecase.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
