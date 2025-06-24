package br.com.cesurgmarau.trabalho_final.infra.controller;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ReviewUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.review.report.ClassificationsByProduct;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.review.report.TotalReviewsByAccount;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.review.report.TotalReviewsByClassification;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ReviewController {
    @Autowired
    private ReviewUseCase reviewUseCase;

    @PostMapping("/review")
    public Review create(@RequestBody Review review) {
        reviewUseCase.create(review);
        return review;
    }

    @PutMapping("/review/{reviewID}")
    public Review update(@PathVariable int reviewID, @RequestBody Review review) {
        reviewUseCase.update(reviewID, review);
        return review;
    }

    @DeleteMapping("/review/{reviewID}")
    public void delete(@PathVariable int reviewID) {
        reviewUseCase.delete(reviewID);
    }

    @GetMapping("/review/{reviewID}")
    public Review getByID(@PathVariable int reviewID) {
        return reviewUseCase.getByID(reviewID);
    }

    @GetMapping("/review")
    public List<Review> fetch(
            @RequestParam(required = false) Integer accountID,
            @RequestParam(required = false) Integer productID,
            @RequestParam(required = false) String classification) {

        if (accountID != null) {
           return reviewUseCase.fetchByAccountID(accountID);
        }

        if (productID != null) {
            return reviewUseCase.fetchByProductID(productID);
        }

        if (classification != null) {
            return reviewUseCase.fetchByClassificationName(classification);
        }

        return reviewUseCase.fetch();
    }

    @GetMapping("/report/classification")
    public List<TotalReviewsByClassification> getTotalReviewsByClassification() {
        return reviewUseCase.getTotalReviewsByClassification();
    }

    @GetMapping("/report/product")
    public List<ClassificationsByProduct> getClassificationsByProduct() {
        return reviewUseCase.getClassificationsByProduct();
    }

    @GetMapping("/report/account")
    public List<TotalReviewsByAccount> getTotalReviewByAccount() {
        return reviewUseCase.getTotalReviewByAccount();
    }

    @GetMapping("/report/general")
    public Map<String, Object> getSystemStatus() {
        return reviewUseCase.getSystemStatus();
    }
}
