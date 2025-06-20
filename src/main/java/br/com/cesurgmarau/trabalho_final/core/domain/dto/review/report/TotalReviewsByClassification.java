package br.com.cesurgmarau.trabalho_final.core.domain.dto.review.report;

public record TotalReviewsByClassification(
        String classification,
        long total
) {
}
