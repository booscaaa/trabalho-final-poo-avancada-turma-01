package br.com.cesurgmarau.trabalho_final.core.domain.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ReviewRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ReviewUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewUseCaseImpl implements ReviewUseCase {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public Review create(Review review) {
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
}
