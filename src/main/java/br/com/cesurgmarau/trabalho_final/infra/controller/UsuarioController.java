package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.usuario.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping("/usuario")
    public void insert(@RequestBody Usuario usuario) {
        usuarioRepository.insert(usuario);
    }

    @GetMapping("/usuario")
    public List<Usuario> list() {
        return usuarioRepository.fetch();
    }

    @PostMapping("/usuario/id")
    public void update(@PathVariable int id, @RequestBody Usuario usuario) {
        usuarioRepository.update(id, usuario);
    }

    @DeleteMapping("/usuario/{id}")
    public void delete(@PathVariable int id) {
        usuarioRepository.delete(id);
    }

    @GetMapping("/usuario/{id}")
    public void get(@PathVariable int id) {
        usuarioRepository.get(id);
    }
}

