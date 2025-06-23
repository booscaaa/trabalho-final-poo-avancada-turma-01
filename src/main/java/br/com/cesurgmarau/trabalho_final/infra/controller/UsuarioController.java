package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.core.dto.usuario.UsuarioResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    private final UsuarioUseCase usuarioUseCase;

    public UsuarioController(UsuarioUseCase usuarioUseCase) {
        this.usuarioUseCase = usuarioUseCase;
    }

    private UsuarioResponseDTO getUsuarioResponseDTO(Usuario usuario) {
        UsuarioResponseDTO responseDTO = new UsuarioResponseDTO();
        responseDTO.setId(usuario.getId());
        responseDTO.setNome(usuario.getNome());
        responseDTO.setEmail(usuario.getEmail());
        return responseDTO;
    }

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
    public UsuarioResponseDTO get(@PathVariable int id) {
        usuarioUseCase.get(id);
        return getUsuarioResponseDTO(usuarioUseCase.get(id));
    }
}



