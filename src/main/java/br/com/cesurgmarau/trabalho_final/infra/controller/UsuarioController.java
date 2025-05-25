package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioUseCase usuarioUseCase;

    @PostMapping("/usuario")
    public void criarUsuario(@RequestBody Usuario usuario){
        usuarioUseCase.adicionarUsuario(usuario);
    }

    @GetMapping("/usuario/{id}")
    public Usuario listarUsuarioPorId (@PathVariable int id){
        return usuarioUseCase.listarUsuarioPorId(id);
    }

    @GetMapping("/usuario")
    public List<Usuario> listarUsuarios(){
        return usuarioUseCase.listarUsuarios();
    }

    @DeleteMapping("/usuario/{id}")
    public void deletarUsuario(@PathVariable int id){
        usuarioUseCase.deletarUsuario(id);
    }

    @PutMapping("/usuario/{id}")
    public void atualizarUsuario(@PathVariable int id, @RequestBody Usuario usuario){
        usuarioUseCase.atualizarUsuario(id, usuario);
    }
}
