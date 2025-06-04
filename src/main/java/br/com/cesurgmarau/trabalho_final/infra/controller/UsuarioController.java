package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.dto.UsuarioRequest;
import br.com.cesurgmarau.trabalho_final.core.dto.UsuarioResponse;
import br.com.cesurgmarau.trabalho_final.core.usecase.UsuarioUsecase;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioUsecase usuarioUsecase;

    public UsuarioController(UsuarioUsecase usuarioUsecase) {
        this.usuarioUsecase = usuarioUsecase;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> criar(@RequestBody UsuarioRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioUsecase.criar(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioResponse> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(usuarioUsecase.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listarTodos() {
        return ResponseEntity.ok(usuarioUsecase.listarTodos());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioResponse> atualizar(@PathVariable Integer id, @RequestBody UsuarioRequest request) {
        return ResponseEntity.ok(usuarioUsecase.atualizar(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        usuarioUsecase.remover(id);
        return ResponseEntity.noContent().build();
    }
}
