package br.com.cesurgmarau.trabalho_final.core.dto;

import java.util.List;

public record ComentarioPorProdutoDTO(
        int id,
        String nome,
        int pontuacao,
        int categoriaId,
        List<ComentarioDTO> comentarioDTOS
){
}
