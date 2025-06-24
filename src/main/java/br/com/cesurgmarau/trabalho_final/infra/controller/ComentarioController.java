package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioRequest;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioResponse;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    private final ComentarioUsecase comentarioUsecase;

    public ComentarioController(ComentarioUsecase comentarioUsecase) {
        this.comentarioUsecase = comentarioUsecase;
    }

    private ComentarioResponse toResponse(Comentario comentario) {
        ComentarioResponse response = new ComentarioResponse();
        response.setId(comentario.getId());
        response.setTexto(comentario.getTexto());
        response.setSentimento(comentario.getSentimento());
        response.setUsuarioId(comentario.getUsuarioId());
        response.setProdutoId(comentario.getProdutoId());
        return response;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ComentarioResponse criar(@RequestBody ComentarioRequest request) {
        Comentario comentario = new Comentario();
        comentario.setTexto(request.getTexto());
        comentario.setUsuarioId(request.getUsuarioId());
        comentario.setProdutoId(request.getProdutoId());

        Comentario salvo = comentarioUsecase.criar(comentario);
        return toResponse(salvo);
    }

    @GetMapping("/{id}")
    public ComentarioResponse buscarPorId(@PathVariable Integer id) {
        Comentario comentario = comentarioUsecase.buscarPorId(id);
        if (comentario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comentário não encontrado");
        }
        return toResponse(comentario);
    }

    @GetMapping
    public List<ComentarioResponse> buscar(
            @RequestParam(required = false) Integer produtoId,
            @RequestParam(required = false) Integer usuarioId,
            @RequestParam(required = false) String sentimento
    ) {
        List<Comentario> comentarios = comentarioUsecase.buscarFiltrado(produtoId, usuarioId, sentimento);
        return comentarios.stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Integer id) {
        Comentario comentario = comentarioUsecase.buscarPorId(id);
        if (comentario == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comentário não encontrado");
        }
        comentarioUsecase.deletar(id);
    }
}
