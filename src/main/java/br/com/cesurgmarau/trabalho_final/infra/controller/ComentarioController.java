package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Comentario.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.ComentarioDTO;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComentarioController {
    @Autowired
    private ComentarioUseCase comentarioUseCase;

    @PostMapping("/comentario")
    public void create(@RequestBody Comentario comentario){
        comentarioUseCase.create(comentario);
    }

    @PutMapping("/comentario/{id}")
    public void update(@RequestBody Comentario comentario, @PathVariable int id){
        comentarioUseCase.update(id, comentario);
    }

    @DeleteMapping("/comentario/{id}")
    public void delete(@PathVariable int id){
        comentarioUseCase.delete(id);
    }

    @GetMapping("/comentario/{id}")
    public ComentarioDTO findById(@PathVariable int id){
        return comentarioUseCase.findById(id);
    }

    @GetMapping("/comentario")
    public List<Comentario> fetch(){
        return comentarioUseCase.fetch();
    }

    @GetMapping("/comentario/produto")
    public List<ComentarioDTO> findByProdutoId(@RequestParam int produtoId){
        return comentarioUseCase.findByProdutoId(produtoId);
    }

    @GetMapping("/comentario/usuario")
    public List<ComentarioDTO> findByUsuarioId(@RequestParam int usuarioId){
        return comentarioUseCase.findByUsuarioId(usuarioId);
    }

    @GetMapping("/comentario/sentimento")
    public List<ComentarioDTO> findByFeeling(@RequestParam String feeling) {
        return comentarioUseCase.findByFeeling(feeling);
    }
}
