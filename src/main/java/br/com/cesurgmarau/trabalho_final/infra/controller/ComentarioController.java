package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioPorSentimentoDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioPorProdutoDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioPorUsuarioDTO;
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
    public ComentarioDTO listarComentarioPorId(@PathVariable int id) {
        return comentarioUseCase.listarComentarioPorId(id);
    }

    @GetMapping("/comentario")
    public List<ComentarioDTO> listarComentario() {
        return comentarioUseCase.listarComentario();
    }


    @GetMapping("/comentario/produtoId/{id}")
    public ComentarioPorProdutoDTO listarProdutoComComentario(@PathVariable int id) {
        return comentarioUseCase.listarComentarioPorProduto(id);
    }

    @GetMapping("/comentario/usuarioId/{id}")
    public ComentarioPorUsuarioDTO listarUsuarioComComentario(@PathVariable int id) {
        return comentarioUseCase.listarComentarioPorUsuario(id);
    }

    @GetMapping("/comentario/sentimentoId/{id}")
    public ComentarioPorSentimentoDTO listarComentarioPorSentimento(@PathVariable int id) {
        return comentarioUseCase.listarComentarioPorSentimento(id);
    }
}