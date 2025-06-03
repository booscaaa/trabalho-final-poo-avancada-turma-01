package br.com.cesurgmarau.trabalho_final.infra.controller;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping
@RestController
public class ComentarioController {

    @Autowired
    private ComentarioUseCase comentarioUseCase;

    @GetMapping("/comentario")
    public List<Comentario> listar() {
        return comentarioUseCase.listar();
    }

    @GetMapping("/comentario/{id}")
    public Comentario listarPorId(@PathVariable int id) {
        return comentarioUseCase.listarPorId(id);
    }

    @PostMapping("/comentario")
    public void adicionarComentario(@RequestBody Comentario comentario) {
        comentarioUseCase.adicionarComentario(comentario);
    }

    @DeleteMapping("/comentario/{id}")
    public String deletarComentario(@PathVariable int id) {
        return comentarioUseCase.deletarComentario(id);
    }

    @PutMapping("/comentario/{id}")
    public String atualizarComentario(@PathVariable int id, @RequestBody Comentario comentario) {
        return comentarioUseCase.atualizarComentario(id, comentario);
    }

}
