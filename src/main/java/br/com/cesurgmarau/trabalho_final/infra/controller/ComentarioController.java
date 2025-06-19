package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ComentarioController {

    private ComentarioUseCase comentarioUseCase;

    @PostMapping("/comentario")
    public void insert(Comentario comentario) {
        comentarioUseCase.insert(comentario);
    }

    @PutMapping("/comentario")
    public void update(int id, Comentario comentario) {
        comentarioUseCase.update(id, comentario);
    }

    @DeleteMapping("/comentario/{id}")
    public void delete(int id) {
        comentarioUseCase.delete(id);
    }

    @GetMapping("/comentario/{id}")
    public Comentario getById(int id) {
        return comentarioUseCase.getById(id);
    }

    @GetMapping("/comentario")
    public List<Comentario> fetch() {
        return comentarioUseCase.fetch();
    }

    @GetMapping("/comentario")
    public List<Comentario> getByProdutoId(int produto_id) {
        return comentarioUseCase.getByProdutoId(produto_id);
    }

    @GetMapping("/comentario")
    public List<Comentario> getByUsuarioId(int comentario_id) {
        return comentarioUseCase.getByUsuarioId(comentario_id);
    }

    @GetMapping("/comentario")
    public List<Comentario> getBySentimento(String sentimento) {
        return comentarioUseCase.getBySentimento(sentimento);
    }
}

