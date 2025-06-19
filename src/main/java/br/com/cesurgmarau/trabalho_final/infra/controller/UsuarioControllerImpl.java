package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.controller.UsuarioController;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase.UsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.dto.request.UsuarioRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.UsuarioResponseDTO;
import br.com.cesurgmarau.trabalho_final.core.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UsuarioControllerImpl implements UsuarioController {

    @Autowired
    UsuarioUseCase usuarioUseCase;

    @PostMapping("/usuario")
    @Override
    public void createUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        usuarioUseCase.createUsuario(UsuarioMapper.toEntity(usuarioRequestDTO));
    }

    @GetMapping("/usuario")
    @Override
    public List<UsuarioResponseDTO> readUsuario() {
        return usuarioUseCase.readUsuario().stream()
                .map(UsuarioMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @PostMapping("/usuario/{id}")
    @Override
    public UsuarioResponseDTO readUsuario(@PathVariable Integer id) {
        return UsuarioMapper.toResponseDTO(usuarioUseCase.readUsuario(id));
    }

    @PutMapping("/usuario/{id}")
    @Override
    public void updateUsuario(@PathVariable Integer id, @RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        usuarioUseCase.updateUsuario(id, UsuarioMapper.toEntity(usuarioRequestDTO));
    }

    @DeleteMapping("/usuario/{id}")
    @Override
    public void deleteUsuario(@PathVariable Integer id) {
        usuarioUseCase.deleteUsuario(id);
    }
}

