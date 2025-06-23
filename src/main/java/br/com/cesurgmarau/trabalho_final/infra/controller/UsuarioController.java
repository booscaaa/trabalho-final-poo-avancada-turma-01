package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.usuario.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @PostMapping()
    public void insert(@RequestBody Usuario usuario) {
        usuarioRepository.insert(usuario);
    }

    @GetMapping()
    public List<Usuario> list() {
        return usuarioRepository.fetch();
    }

    @PostMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Usuario usuario) {
        usuarioRepository.update(id, usuario);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        usuarioRepository.delete(id);
    }

    @GetMapping("/{id}")
    public Usuario get(@PathVariable int id) {
        return usuarioRepository.get(id);
    }
}

