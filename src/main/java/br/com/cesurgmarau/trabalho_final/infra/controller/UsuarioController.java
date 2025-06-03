package br.com.cesurgmarau.trabalho_final.infra.controller;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UsuarioController {

    @Autowired
    private UsuarioUseCase usuarioUseCase;

    @GetMapping("/usuario")
    public List<Usuario> listar() {
        return usuarioUseCase.listar();
    }

    @GetMapping("/usuario/{id}")
    public Usuario listarPorId(@PathVariable int id) {
        return usuarioUseCase.listarPorId(id);
    }

    @PostMapping("/usuario")
    public void adicionarUsuario(@RequestBody Usuario usuario) {
        usuarioUseCase.adicionarUsuario(usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public String deletarUsuario(@PathVariable int id) {
        return usuarioUseCase.deletarUsuario(id);
    }

    @PutMapping("/usuario/{id}")
    public String atualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        return usuarioUseCase.atualizarUsuario(id, usuario);
    }

}
