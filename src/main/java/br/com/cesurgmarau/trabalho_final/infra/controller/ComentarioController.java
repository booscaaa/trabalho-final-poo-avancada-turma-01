package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioRequest;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioResponse;
import br.com.cesurgmarau.trabalho_final.core.usecase.CriarComentarioUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final CriarComentarioUsecase criarComentarioUsecase;

    public ComentarioController(CriarComentarioUsecase criarComentarioUsecase) {
        this.criarComentarioUsecase = criarComentarioUsecase;
    }

    @PostMapping
    public ResponseEntity<ComentarioResponse> criarComentario(@RequestBody ComentarioRequest comentarioRequest) {
        ComentarioResponse comentarioResponseDTO = criarComentarioUsecase.criar(comentarioRequest);
        return new ResponseEntity<>(comentarioResponseDTO, HttpStatus.CREATED);
    }
}
