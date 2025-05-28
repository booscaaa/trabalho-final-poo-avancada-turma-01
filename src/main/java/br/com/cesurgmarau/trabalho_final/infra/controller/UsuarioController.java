package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioController {
    @Autowired
    private UsuarioUseCase usuarioUseCase;

    @PostMapping("/usuario")
    public void adicionarUsuario(@RequestBody Usuario usuario){
        usuarioUseCase.adicionarUsuario(usuario);
    }

    @GetMapping("/usuarios")
    public List<Usuario> listar(){
        return usuarioUseCase.listarUsuarios();
    }
}
