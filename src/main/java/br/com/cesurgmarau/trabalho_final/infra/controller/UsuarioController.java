package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.core.dto.UsuarioRequest;
import br.com.cesurgmarau.trabalho_final.core.dto.UsuarioResponse;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioUsecase usuarioUsecase;

    public UsuarioController(UsuarioUsecase usuarioUsecase) {
        this.usuarioUsecase = usuarioUsecase;
    }

    private UsuarioResponse toResponse(Usuario usuario) {
        UsuarioResponse response = new UsuarioResponse();
        response.setId(usuario.getId());
        response.setNome(usuario.getNome());
        response.setEmail(usuario.getEmail());
        return response;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioResponse criar(@RequestBody UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        Usuario criado = usuarioUsecase.criar(usuario);
        return toResponse(criado);
    }

    @GetMapping("/{id}")
    public UsuarioResponse buscarPorId(@PathVariable Integer id) {
        Usuario usuario = usuarioUsecase.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado"));
        return toResponse(usuario);
    }

    @GetMapping
    public List<UsuarioResponse> listarTodos() {
        return usuarioUsecase.listarTodos().stream()
                .map(this::toResponse)
                .toList();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizar(@PathVariable Integer id, @RequestBody UsuarioRequest request) {
        Usuario usuario = new Usuario();
        usuario.setNome(request.getNome());
        usuario.setEmail(request.getEmail());
        usuarioUsecase.atualizar(id, usuario);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id) {
        usuarioUsecase.remover(id);
    }
}