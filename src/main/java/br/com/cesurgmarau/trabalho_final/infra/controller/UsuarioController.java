package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Usuario.UsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioUseCase usuarioUseCase;

    @PostMapping("/usuario")
    public void create(@RequestBody Usuario usuario) {
        usuarioUseCase.create(usuario);
    }

    @PutMapping("/usuario/{id}")
    public void update(@PathVariable int id,@RequestBody Usuario usuario) {
        usuarioUseCase.update(id, usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public void delete(@PathVariable int id) {
        usuarioUseCase.delete(id);
    }

    @GetMapping("/usuario/{id}")
    public Usuario fetchById(@PathVariable int id) {
        return usuarioUseCase.fetchById(id);
    }

    @GetMapping("/usuario")
    public List<Usuario> fetch() {
        return usuarioUseCase.fetch();
    }
}
