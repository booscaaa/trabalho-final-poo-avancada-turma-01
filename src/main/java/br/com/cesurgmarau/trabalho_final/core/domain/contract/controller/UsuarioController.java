package br.com.cesurgmarau.trabalho_final.core.domain.contract.controller;

import br.com.cesurgmarau.trabalho_final.core.dto.request.UsuarioRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.UsuarioResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UsuarioController {
    public ResponseEntity<Void> createUsuario(UsuarioRequestDTO usuarioRequestDTO);
    public ResponseEntity<List<UsuarioResponseDTO>> readUsuario();
    public ResponseEntity<UsuarioResponseDTO> readUsuario(Integer id);
    public ResponseEntity<Void> updateUsuario(Integer id, UsuarioRequestDTO usuarioRequestDTO);
    public ResponseEntity<Void> deleteUsuario(Integer id);
}
