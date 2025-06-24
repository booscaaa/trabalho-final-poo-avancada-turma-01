package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Comentario.ComentarioController;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Comentario.ComentarioUsecase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComentarioControllerIMPL implements ComentarioController {
    @Autowired
    ComentarioUsecase comentarioUsecase;
    @Override @PostMapping("/comentario")
    public void cadastrarComentario(@RequestBody ComentarioDTO comentarioDTO) {
        Comentario comentario =  new Comentario(null, comentarioDTO.getAssunto(), comentarioDTO.getDescricao(), comentarioDTO.getProduto(), comentarioDTO.getUsuario());
        comentarioUsecase.cadastrarComentario(comentario);
    }

    @Override @GetMapping("/comentario")
    public List<Comentario> listarComentario() {
        return comentarioUsecase.listarComentario();
    }

    @Override @GetMapping("/comentario/{id}")
    public Comentario getId(Long id) {
        return comentarioUsecase.getId(id);
    }

    @Override @PutMapping("/comentario/{id}")
    public void atualizarComentario(Comentario comentario, Long id) {
        comentarioUsecase.atualizarComentario(comentario, id);
    }

    @Override @DeleteMapping("/comentario/{id}")
    public void deletaComentario(Long id) {
        comentarioUsecase.deletaComentario(id);
    }
}
