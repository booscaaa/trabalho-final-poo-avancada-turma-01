package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UsuarioController {

    private UsuarioUseCase usuarioUseCase;


    @PostMapping("/usuario")
    public void insert(@RequestBody Usuario usuario) {
        usuarioUseCase.insert(usuario);
    }

    @GetMapping("/usuario")
    public List<Usuario> fetch() {
        return usuarioUseCase.fetch();
    }

    @PostMapping("/usuario/{id}")
    public void update(@PathVariable int id, @RequestBody Usuario usuario) {
        usuarioUseCase.update(id, usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public void delete(@PathVariable int id) {
        usuarioUseCase.delete(id);
    }

    @GetMapping("/usuario/{id}")
    public void get(@PathVariable int id) {
        usuarioUseCase.get(id);
    }
}



