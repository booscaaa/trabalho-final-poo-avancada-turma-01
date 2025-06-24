package br.com.cesurgmarau.trabalho_final.core.mapper;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.core.dto.request.ComentarioRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.ComentarioResponseDTO;

import java.time.LocalDateTime;

public class ComentarioMapper {
    public static Comentario toEntity(ComentarioRequestDTO dto, Usuario usuario, Produto produto) {
        return new Comentario(
                0,
                dto.getTexto(),
                usuario,
                produto,
                dto.getSentimento(),
                LocalDateTime.now()
        );
    }

    public static ComentarioResponseDTO toResponseDTO(Comentario comentario) {
        return new ComentarioResponseDTO(
        comentario.getId(),
        comentario.getTexto(),
        comentario.getUsuario().getId(),
        comentario.getProduto().getId(),
        comentario.getSentimento(),
        comentario.getData());
    }
}
