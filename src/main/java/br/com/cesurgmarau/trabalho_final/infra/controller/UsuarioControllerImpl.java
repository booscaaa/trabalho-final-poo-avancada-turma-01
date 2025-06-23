package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.controller.UsuarioController;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase.UsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.dto.request.UsuarioRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.UsuarioResponseDTO;
import br.com.cesurgmarau.trabalho_final.core.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UsuarioControllerImpl implements UsuarioController {

    @Autowired
    UsuarioUseCase usuarioUseCase;

    @PostMapping("/usuario")
    @Override
    public ResponseEntity<Void> createUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        usuarioUseCase.createUsuario(UsuarioMapper.toEntity(usuarioRequestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/usuario")
    @Override
    public ResponseEntity<List<UsuarioResponseDTO>> readUsuario() {
        List<UsuarioResponseDTO> usuariosDTO = usuarioUseCase.readUsuario().stream()
                .map(UsuarioMapper::toResponseDTO)
                .collect(Collectors.toList());

        if (usuariosDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuariosDTO);
    }

    @GetMapping("/usuario/{id}")
    @Override
    public ResponseEntity<UsuarioResponseDTO> readUsuario(@PathVariable Integer id) {
        UsuarioResponseDTO usuarioDTO = UsuarioMapper.toResponseDTO(usuarioUseCase.readUsuario(id));

        if (usuarioDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioDTO);
    }

    @PutMapping("/usuario/{id}")
    @Override
    public ResponseEntity<Void> updateUsuario(@PathVariable Integer id, @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        usuarioUseCase.updateUsuario(id, UsuarioMapper.toEntity(usuarioRequestDTO));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/usuario/{id}")
    @Override
    public ResponseEntity<Void> deleteUsuario(@PathVariable Integer id) {
        usuarioUseCase.deleteUsuario(id);
        return ResponseEntity.noContent().build();
    }
}

