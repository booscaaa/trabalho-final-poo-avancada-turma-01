package br.com.cesurgmarau.trabalho_final.controller;

import br.com.cesurgmarau.trabalho_final.dto.ComentarioDTO;
import br.com.cesurgmarau.trabalho_final.dto.ComentarioRequestDTO;
import br.com.cesurgmarau.trabalho_final.service.interfaces.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comentarios")
public class ComentarioController {

    @Autowired
    private ComentarioService service;

    @PostMapping
    public ComentarioDTO criar(@RequestBody ComentarioRequestDTO dto) {
        return service.salvar(dto);
    }

    @GetMapping("/{id}")
    public ComentarioDTO buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @GetMapping
    public List<ComentarioDTO> listar(
            @RequestParam(required = false) Long produtoId,
            @RequestParam(required = false) Long usuarioId,
            @RequestParam(required = false) String sentimento) {

        if (produtoId != null) {
            return service.buscarPorProduto(produtoId);
        }
        if (usuarioId != null) {
            return service.buscarPorUsuario(usuarioId);
        }
        if (sentimento != null) {
            return service.buscarPorSentimento(sentimento);
        }
        return service.listarTodos();
    }
}
