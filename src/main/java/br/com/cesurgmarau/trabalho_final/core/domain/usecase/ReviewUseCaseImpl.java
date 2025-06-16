package br.com.cesurgmarau.trabalho_final.core.domain.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.*;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.ReviewReport;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewUseCaseImpl implements ReviewUseCase {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MaritacaAIGateway maritacaAIGateway;

    @Autowired
    private ClassificationRepository classificationRepository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Review create(Review review) {
        var assess = maritacaAIGateway.commentAssess(review.getComment());
        review.setClassificationID(classificationRepository.getByName(assess).getId());

        var score = maritacaAIGateway.commentScore(review.getComment());
        review.setScoreID(scoreRepository.getByName(score).getId());

        var account = accountRepository.getByID(review.getAccountID());

        account.setCommentScore(
                (String.valueOf(
                        (Integer.parseInt(account.getCommentScore()) + Integer.parseInt(score)) / 2)
                )
        );

        accountRepository.update(account.getId(), account);

        return reviewRepository.create(review);
    }

    @Override
    public Review update(int reviewID, Review review) {
        return reviewRepository.update(reviewID, review);
    }

    @Override
    public void delete(int reviewID) {
        reviewRepository.delete(reviewID);
    }

    @Override
    public Review getByID(int reviewID) {
        return reviewRepository.getByID(reviewID);
    }

    @Override
    public List<Review> fetch() {
        return reviewRepository.fetch();
    }

    @Override
    public List<ReviewReport.TotalReviewsByClassification> getTotalReviewsByClassification() {
        return reviewRepository.getTotalReviewsByClassification();
    }

    @Override
    public List<ReviewReport.ClassificationsByProduct> getClassificationsByProduct() {
        return reviewRepository.getClassificationsByProduct();
    }

    @Override
    public List<ReviewReport.TotalReviewByAccount> getTotalReviewByAccount() {
        return reviewRepository.getTotalReviewByAccount();
    }

    @Override
    public List<Review> fetchByProductID(int productID) {
        return reviewRepository.fetchByProductID(productID);
    }

    @Override
    public List<Review> fetchByClassificationName(String classificationName) {
        return reviewRepository.fetchByClassificationName(classificationName);
    }

    @Override
    public List<Review> fetchByAccountID(int accountID) {
        return reviewRepository.fetchByAccountID(accountID);
    }


}
