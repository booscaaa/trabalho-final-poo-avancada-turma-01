package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.dto.ReviewReport;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Review;

import java.util.List;

public interface ReviewUseCase {
    public Review create(Review review);
    public Review update(int reviewID, Review review);
    public void delete(int reviewID);
    public Review getByID(int reviewID);
    public List<Review> fetch();

    public List<ReviewReport.TotalReviewsByClassification> getTotalReviewsByClassification();
    public List<ReviewReport.ClassificationsByProduct> getClassificationsByProduct();
    public List<ReviewReport.TotalReviewByAccount> getTotalReviewByAccount();
}
