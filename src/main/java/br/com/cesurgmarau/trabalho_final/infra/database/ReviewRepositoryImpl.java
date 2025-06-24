package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ReviewRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.review.report.ClassificationsByProduct;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.review.report.TotalReviewsByAccount;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.review.report.TotalReviewsByClassification;
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
                INSERT INTO review(account_id, classification_id, product_id, score_id, comment)
                VALUES (:account_id, :classification_id, :product_id, :score_id, :comment)
                RETURNING id;
                """;

        var id = (Number) entityManager.createNativeQuery(query)
                .setParameter("account_id", review.getAccountID())
                .setParameter("classification_id", review.getClassificationID())
                .setParameter("product_id", review.getProductID())
                .setParameter("score_id", review.getScoreID())
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
                score_id = :score_id,
                comment = :comment
                WHERE id = :id
                """;

        var rowsAffected = entityManager.createNativeQuery(query)
                .setParameter("account_id", review.getAccountID())
                .setParameter("classification_id", review.getClassificationID())
                .setParameter("product_id", review.getProductID())
                .setParameter("score_id", review.getScoreID())
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
        var query = """
                SELECT r.id, r.account_id, r.product_id, r.classification_id, r.score_id, comment, a.name AS account_name, p.name AS product, c.name AS classification, s.name AS score FROM review AS r
                INNER JOIN account AS a ON a.id = r.account_id
                INNER JOIN product AS p ON p.id = r.product_id
                INNER JOIN classification AS c ON c.id = r.classification_id
                INNER JOIN score AS s ON s.id = r.score_id
                """;

        return entityManager.createNativeQuery(query, Review.class).getResultList();
    }

    @Override
    public List<TotalReviewsByClassification> getTotalReviewsByClassification() {
        var query = """
                SELECT c.name AS classification, COUNT(c.name) AS quantidade FROM review AS r
                INNER JOIN account AS a ON a.id = r.account_id
                INNER JOIN product AS p ON p.id = r.product_id
                INNER JOIN classification AS c ON c.id = r.classification_id
                INNER JOIN score AS s ON s.id = r.score_id
                GROUP BY classification;
                """ ;
        return entityManager.createNativeQuery(query, TotalReviewsByClassification.class).getResultList();
    }

    @Override
    public List<ClassificationsByProduct> getClassificationsByProduct() {
        var query = """
            SELECT p.name AS produto,
                    COUNT(*) FILTER (WHERE c.name = 'MUITO BOM')  AS "MUITO BOM",
                    COUNT(*) FILTER (WHERE c.name = 'BOM')  AS "BOM",
                    COUNT(*) FILTER (WHERE c.name = 'MÉDIO') AS "MÉDIO",
                    COUNT(*) FILTER (WHERE c.name = 'RUIM') AS "RUIM",
                    COUNT(*) FILTER (WHERE c.name = 'MUITO RUIM') AS "MUITO RUIM",
                    COUNT(*) FILTER (WHERE c.name = 'INDEFINIDO') AS "INDEFINIDO",
                    COUNT(*) AS total
            FROM review r
            JOIN product p ON p.id = r.product_id
            JOIN classification c ON c.id = r.classification_id
            INNER JOIN score AS s ON s.id = r.score_id
            GROUP BY p.name
            ORDER BY p.name;
        """;

        return entityManager.createNativeQuery(query, ClassificationsByProduct.class).getResultList();
    }

    @Override
    public List<TotalReviewsByAccount> getTotalReviewByAccount() {
        var query = """
                SELECT a.name AS account, COUNT(c.name) AS quantidade FROM review AS r
                INNER JOIN account AS a ON a.id = r.account_id
                INNER JOIN product AS p ON p.id = r.product_id
                INNER JOIN classification AS c ON c.id = r.classification_id
                INNER JOIN score AS s ON s.id = r.score_id
                GROUP BY account;
                """ ;
        return entityManager.createNativeQuery(query, TotalReviewsByAccount.class).getResultList();

    }

    @Override
    public List<Review> fetchByProductID(int productID) {
        var query = """
                SELECT r.id, r.account_id, r.product_id, r.classification_id, r.score_id, comment, a.name AS account_name, p.name AS product, c.name AS classification, s.name AS score  FROM review AS r
                INNER JOIN account AS a ON a.id = r.account_id
                INNER JOIN product AS p ON p.id = r.product_id
                INNER JOIN classification AS c ON c.id = r.classification_id
                INNER JOIN score AS s ON s.id = r.score_id
                WHERE r.product_id = :product_id""";

        return entityManager.createNativeQuery(query, Review.class)
                .setParameter("product_id", productID)
                .getResultList();
    }

    @Override
    public List<Review> fetchByClassificationName(String classificationName) {
        var query = """
                SELECT r.id, r.account_id, r.product_id, r.classification_id, r.score_id, comment, a.name AS account_name, p.name AS product, c.name AS classification, s.name AS score FROM review AS r
                INNER JOIN account AS a ON a.id = r.account_id
                INNER JOIN product AS p ON p.id = r.product_id
                INNER JOIN classification AS c ON c.id = r.classification_id
                INNER JOIN score AS s ON s.id = r.score_id
                WHERE c.name = :classification""";

        return entityManager.createNativeQuery(query, Review.class).setParameter("classification", classificationName).getResultList();
    }

    @Override
    public List<Review> fetchByAccountID(int accountID) {
        var query = """
                SELECT r.id, r.account_id, r.product_id, r.classification_id, r.score_id, comment, a.name AS account_name, p.name AS product, c.name AS classification, s.name AS score FROM review AS r
                INNER JOIN account AS a ON a.id = r.account_id
                INNER JOIN product AS p ON p.id = r.product_id
                INNER JOIN classification AS c ON c.id = r.classification_id
                INNER JOIN score AS s ON s.id = r.score_id
                WHERE r.account_id = :account_id""";

        return entityManager.createNativeQuery(query, Review.class)
                .setParameter("account_id", accountID)
                .getResultList();
    }


}
