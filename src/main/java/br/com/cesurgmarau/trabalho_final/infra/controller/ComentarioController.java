package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class ComentarioController {

    @Autowired
    private ComentarioUseCase comentarioUseCase;

    @PostMapping("/comentario")
    public void criarComentario(@RequestBody Comentario comentario) throws IOException {
        comentarioUseCase.adicionarComentario(comentario);
    }

    @GetMapping("/comentario/{id}")
    public Comentario listarComentarioPorId (@PathVariable int id){
        return comentarioUseCase.listarComentarioPorId(id);
    }

    @GetMapping("/comentario")
    public List<Comentario> listarComentario(){
        return comentarioUseCase.listarComentario();
    }
}
