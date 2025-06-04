package br.com.cesurgmarau.trabalho_final.core.mapper;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.core.dto.request.UsuarioRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.UsuarioResponseDTO;

public class UsuarioMapper {
    public static Usuario toEntity(UsuarioRequestDTO dto) {
        return new Usuario(0, dto.getNome(), dto.getSenha(), dto.getEmail());
    }

    public static UsuarioResponseDTO toResponseDTO(Usuario usuario) {
        return new UsuarioResponseDTO(
        usuario.getId(),
        usuario.getNome(),
        usuario.getSenha(),
        usuario.getEmail());
    }
}
