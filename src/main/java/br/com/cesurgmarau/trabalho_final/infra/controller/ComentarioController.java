package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioUseCase comentarioUseCase;

    @PostMapping()
    public void insert(@RequestBody Comentario comentario) {
        comentarioUseCase.insert(comentario);
    }

    @GetMapping()
    public List<Comentario> buscarTodosOsComentarios() {
        return comentarioUseCase.buscarTodosOsComentarios();
    }

    @PostMapping("/{id}")
        public void update(@PathVariable int id, @RequestBody Comentario comentario){
        comentarioUseCase.update(id, comentario);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        comentarioUseCase.delete(id);
    }
    @GetMapping("/{id}")
    public Comentario buscarComentarioPorId(@PathVariable int id) {
        return comentarioUseCase.buscarComentarioPorId(id);
    }
    @GetMapping("?produtoId=1")
    public Comentario buscarProdutoPorId(@RequestParam int livroId) {
       return (Comentario) comentarioUseCase.buscarProdutoPorId(livroId);
    }
    @GetMapping("?usuarioId=1")
    public List<Comentario> buscarUsuarioPorId(@RequestParam int usuarioId) {
       return comentarioUseCase.buscarUsuarioPorId(usuarioId);
    }
}
