package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController("/comentario")
public class ComentarioController {

    @Autowired
    private ComentarioUseCase comentarioUseCase;

    @PostMapping("/comentario")
    public void insert(@RequestBody Comentario comentario) {
        comentarioUseCase.insert(comentario);
    }

    @GetMapping("/comentario")
    public List<Comentario> list() {
        return comentarioUseCase.fetch();
    }

    @PostMapping("/comentario/id")
        public void update(@PathVariable int id, @RequestBody Comentario comentario){
        comentarioUseCase.update(id, comentario);
    }

    @DeleteMapping("/comentario/{id}")
    public void delete(@PathVariable int id) {
        comentarioUseCase.delete(id);
    }

    @GetMapping("/comentario/{id}")
    public void get(@PathVariable int id) {
        comentarioUseCase.get(id);
    }
}
