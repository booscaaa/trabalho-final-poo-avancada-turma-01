package br.com.cesurgmarau.trabalho_final.core.domain.dto.review.report;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClassificationsByProduct(
        String product,
        @JsonProperty("muito_bom")
        long muitoBom,
        long bom,
        long medio,
        long ruim,
        @JsonProperty("muito_ruim")
        long muitoRuim,
        long total
) {
}
