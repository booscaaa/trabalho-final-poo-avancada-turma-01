package br.com.cesurgmarau.trabalho_final.infra.controller;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.TipoSentimento;
import br.com.cesurgmarau.trabalho_final.core.dto.Comentario.ComentarioRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioUseCase comentarioUseCase;

    public ComentarioController(ComentarioUseCase comentarioUseCase) {
        this.comentarioUseCase = comentarioUseCase;
    }

    @PostMapping
    public ResponseEntity<Comentario> criar(@RequestBody ComentarioRequestDTO dto) {
        Comentario salvo = comentarioUseCase.criarComentario(dto);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Comentario> buscarPorId(@PathVariable Long id) {
        Optional<Comentario> comentario = comentarioUseCase.buscarPorId(id);
        return comentario.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Comentario>> listarTodos(
            @RequestParam(required = false) Long produtoId,
            @RequestParam(required = false) Long usuarioId,
            @RequestParam(required = false) TipoSentimento sentimento
    ) {
        if (produtoId != null) {
            return ResponseEntity.ok(comentarioUseCase.buscarPorProdutoId(produtoId));
        } else if (usuarioId != null) {
            return ResponseEntity.ok(comentarioUseCase.buscarPorUsuarioId(usuarioId));
        } else if (sentimento != null) {
            return ResponseEntity.ok(comentarioUseCase.buscarPorSentimento(sentimento));
        } else {
            return ResponseEntity.ok(comentarioUseCase.listarTodos());
        }
    }

}

