package br.com.cesurgmarau.trabalho_final.infra.database.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ReportRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReportRepositoryImpl implements ReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Object[]> getCommentCountByFeelingId(int id) {
        String sql = """
                    SELECT f.name, COUNT(c.id)
                    FROM comments c
                    JOIN feelings f ON c.feeling_id = f.id
                    WHERE f.id = :id
                    GROUP BY f.name
                """;

        return entityManager.createNativeQuery(sql)
                .setParameter("id", id)
                .getResultList();
    }

    public List<Object[]> getFeelingDataByProductId(int id) {
        String sql = """
        SELECT p.name, f.name, f.value
        FROM comments c
        JOIN products p ON c.product_id = p.id
        JOIN feelings f ON c.feeling_id = f.id
        WHERE p.id = :id
    """;

        return entityManager.createNativeQuery(sql)
                .setParameter("id", id)
                .getResultList();
    }




    @Override
    public List<Object[]> getUserRanking() {
        String sql = """
        SELECT u.name, COUNT(c.id) AS total_comentarios
        FROM users u
        LEFT JOIN comments c ON c.user_id = u.id
        GROUP BY u.name
        ORDER BY total_comentarios DESC
    """;

        return entityManager.createNativeQuery(sql).getResultList();
    }

}
