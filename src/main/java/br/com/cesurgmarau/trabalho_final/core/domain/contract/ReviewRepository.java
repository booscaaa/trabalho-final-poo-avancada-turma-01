package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.dto.review.report.ClassificationsByProduct;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.review.report.TotalReviewsByAccount;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.review.report.TotalReviewsByClassification;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Review;

import java.util.List;

public interface ReviewRepository {
    public Review create(Review review);
    public Review update(int reviewID, Review review);
    public void delete(int reviewID);
    public Review getByID(int reviewID);
    public List<Review> fetch();

    public List<TotalReviewsByClassification> getTotalReviewsByClassification();
    public List<ClassificationsByProduct> getClassificationsByProduct();
    public List<TotalReviewsByAccount> getTotalReviewByAccount();

    public List<Review> fetchByProductID(int productID);
    public List<Review> fetchByClassificationName(String classificationName);
    public List<Review> fetchByAccountID(int accountID);
}
