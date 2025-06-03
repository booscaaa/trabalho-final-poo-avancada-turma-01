package br.com.cesurgmarau.trabalho_final.core.dto;

import jakarta.persistence.Column;

import java.util.List;

public record ComentarioPorSentimentoDTO(
        int id,
        String tipo,
        int ponto,
        int quantidade,
        List<ComentarioDTO> comentarioDTOS
) {
}
