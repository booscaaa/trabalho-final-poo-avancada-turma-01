package br.com.cesurgmarau.trabalho_final.core.domain.contract.controller;

import br.com.cesurgmarau.trabalho_final.core.dto.request.UsuarioRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioController {
    public void createUsuario(UsuarioRequestDTO usuarioRequestDTO);
    public List<UsuarioResponseDTO> readUsuario();
    public UsuarioResponseDTO readUsuario(int id);
    public void updateUsuario(int id, UsuarioRequestDTO usuarioRequestDTO);
    public void deleteUsuario(int id);
}
