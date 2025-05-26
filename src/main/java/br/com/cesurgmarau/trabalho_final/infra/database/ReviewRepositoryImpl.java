package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ReviewRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Review;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public Review create(Review review) {
        var query = """
                INSERT INTO review(account_id, classification_id, product_id, comment)
                VALUES (:account_id, :classification_id, :product_id, :comment)
                RETURNING id;
                """;

        var id = (Number) entityManager.createNativeQuery(query)
                .setParameter("account_id", review.getAccountID())
                .setParameter("classification_id", review.getClassificationID())
                .setParameter("product_id", review.getProductID())
                .setParameter("comment", review.getComment())
                .getSingleResult();

        review.setId(id.intValue());
        return review;
    }

    @Transactional
    @Override
    public Review update(int reviewID, Review review) {
        var query = """
                UPDATE review SET
                account_id = :account_id,
                classification_id = :classification_id,
                product_id = :product_id,
                comment = :comment
                WHERE id = :id
                """;

        var rowsAffected = entityManager.createNativeQuery(query)
                .setParameter("account_id", review.getAccountID())
                .setParameter("classification_id", review.getClassificationID())
                .setParameter("product_id", review.getProductID())
                .setParameter("comment", review.getComment())
                .setParameter("id", reviewID)
                .executeUpdate();

        if (rowsAffected == 0) {
            throw new RuntimeException("Review not found with id: " + reviewID);
        }

        review.setId(reviewID);
        return review;
    }

    @Transactional
    @Override
    public void delete(int reviewID) {
        var query = "DELETE FROM review WHERE id = :id;";
        entityManager.createNativeQuery(query, Review.class)
                .setParameter("id", reviewID)
                .executeUpdate();
    }

    @Override
    public Review getByID(int reviewID) {
        var query = "SELECT * FROM review WHERE id = :id;";

        return (Review) entityManager.createNativeQuery(query, Review.class)
                .setParameter("id", reviewID)
                .getSingleResult();
    }

    @Override
    public List<Review> fetch() {
        var query = "SELECT * FROM review;";

        return entityManager.createNativeQuery(query, Review.class).getResultList();
    }

}
