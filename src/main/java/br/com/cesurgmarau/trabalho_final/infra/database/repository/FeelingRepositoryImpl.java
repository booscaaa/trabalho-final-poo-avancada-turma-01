package br.com.cesurgmarau.trabalho_final.infra.database.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.FeelingRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Feeling;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class FeelingRepositoryImpl implements FeelingRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Optional<Feeling> findByNameIgnoreCase(String name) {
        try {
            Feeling feeling = entityManager.createQuery(
                            "SELECT f FROM Feeling f WHERE LOWER(f.name) = LOWER(:name)", Feeling.class)
                    .setParameter("name", name)
                    .getSingleResult();
            return Optional.of(feeling);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
