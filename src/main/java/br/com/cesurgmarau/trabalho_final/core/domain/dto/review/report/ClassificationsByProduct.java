package br.com.cesurgmarau.trabalho_final.core.domain.dto.review.report;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ClassificationsByProduct(
        String product,
        @JsonProperty("muitoBom")
        long muitoBom,
        long bom,
        long medio,
        long ruim,
        @JsonProperty("muitoRuim")
        long muitoRuim,
        long indefinido,
        long total
) {
}
