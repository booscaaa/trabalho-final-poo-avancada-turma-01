package br.com.cesurgmarau.trabalho_final.core.dto;

import java.util.List;

public record ComentarioPorUsuarioDTO(
        int id,
        String cpf,
        String nome,
        List<ComentarioDTO> comentarioDTOS
) {
}
