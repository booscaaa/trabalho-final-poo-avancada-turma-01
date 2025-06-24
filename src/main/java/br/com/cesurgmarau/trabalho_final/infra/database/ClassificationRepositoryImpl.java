package br.com.cesurgmarau.trabalho_final.infra.database;


import br.com.cesurgmarau.trabalho_final.core.domain.contract.ClassificationRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Classification;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassificationRepositoryImpl implements ClassificationRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public Classification create(Classification classification) {
        var query = """
                INSERT INTO classification(name)
                VALUES (:name)
                RETURNING id
                """;

        var id = (Number) entityManager.createNativeQuery(query)
                .setParameter("name", classification.getName())
                .getSingleResult();

        classification.setId(id.intValue());
        return classification;
    }

    @Transactional
    @Override
    public Classification update(int classificationID, Classification classification) {
        var query = """
                UPDATE classification SET
                name = :name
                WHERE id = :id
                """;

        var rowsAffected = entityManager.createNativeQuery(query, Classification.class)
                .setParameter("name", classification.getName())
                .setParameter("id", classificationID)
                .executeUpdate();

        if (rowsAffected == 0) {
            throw new RuntimeException("Classification not found with id: " + classificationID);
        }

        classification.setId(classificationID);
        return classification;
    }

    @Transactional
    @Override
    public void delete(int classificationID) {
        var query = "DELETE FROM classification WHERE id = :id;";
        entityManager.createNativeQuery(query, Classification.class)
                .setParameter("id", classificationID)
                .executeUpdate();
    }

    @Override
    public Classification getByID(int classificationID) {
        var query = "SELECT * FROM classification WHERE id = :id;";

        return (Classification) entityManager.createNativeQuery(query, Classification.class)
                .setParameter("id", classificationID)
                .getSingleResult();
    }

    @Override
    public Classification getByName(String name) {
        var query = "SELECT * FROM classification WHERE name = :name;";
        return (Classification) entityManager.createNativeQuery(query, Classification.class)
                .setParameter("name", name)
                .getSingleResult();
    }

    @Override
    public List<Classification> fetch() {
        var query = "SELECT * FROM classification;";

        return entityManager.createNativeQuery(query, Classification.class).getResultList();
  }

}
