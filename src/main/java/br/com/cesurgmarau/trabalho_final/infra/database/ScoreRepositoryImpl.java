package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ScoreRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Score;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScoreRepositoryImpl implements ScoreRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Score> fetch() {
        var query = "SELECT * FROM score";

        return entityManager.createNativeQuery(query, Score.class).getResultList();

    }

    @Override
    public Score getByName(String name) {
        var query = "SELECT * FROM score WHERE name = :name;";
        return (Score) entityManager.createNativeQuery(query, Score.class)
                .setParameter("name", name)
                .getSingleResult();
    }
}
