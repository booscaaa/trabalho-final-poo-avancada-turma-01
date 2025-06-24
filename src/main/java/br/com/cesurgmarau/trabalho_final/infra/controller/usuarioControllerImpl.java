package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Usuario.UsuarioController;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Usuario.UsuarioUsecase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.core.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class UsuarioControllerIMPL implements UsuarioController {

    @Autowired
    UsuarioUsecase usuarioUsecase;


    @Override @PostMapping("/usuario")
    public void cadastraUsuario(@RequestBody UsuarioDTO usuarioDTO) {
        Usuario usuario = new Usuario(null, usuarioDTO.getNome(),usuarioDTO.getIdade());

        usuarioUsecase.cadastraUsuario(usuario);

    }

    @Override @GetMapping("/usuario")
    public List<Usuario> listarUsuario() {
        return usuarioUsecase.listarUsuario();
    }

    @Override @GetMapping("/usuario/{id}")
    public Usuario getId(@PathVariable Long id) {
        return usuarioUsecase.getId(id);
    }

    @Override @PutMapping("/usuario/{id}")
    public void atualizaUsuario(@RequestBody UsuarioDTO usuarioDTO,@PathVariable Long id) {
        Usuario usuario = new Usuario(null, usuarioDTO.getNome(),usuarioDTO.getIdade());

        usuarioUsecase.atualizaUsuario(usuario, id);
    }

    @Override @DeleteMapping("/usuario/{id}")
    public void deletaUsuario(@PathVariable Long id) {
        usuarioUsecase.deletaUsuario(id);
    }
}
