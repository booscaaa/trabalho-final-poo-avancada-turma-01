package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Sentimento.SentimentoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Sentimentos;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SentimentoRepositoryIMPL implements SentimentoRepository {
    @Autowired
    EntityManager entityManager;

    @Transactional
    @Override
    public void cadastrarSentimento(Sentimentos sentimentos) {
        String query = "INSERT INTO sentimento(sentimento) VALUES(:sentimento)";

        entityManager.createNativeQuery(query)
                .setParameter("sentimento", sentimentos.getSentimento())
                .executeUpdate();
    }

    @Override
    public List<Sentimentos> listarSentimento() {
        String query = "SELECT * FROM sentimento";

        return entityManager.createNativeQuery(query, Sentimentos.class)
                .getResultList();
    }

    @Override
    public Sentimentos getId(Long id) {
        String query = "SELECT * FROM sentimento WHERE id = id";

        return (Sentimentos) entityManager.createNativeQuery(query, Sentimentos.class)
                .setParameter("id",id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void atualizarSentimento(Sentimentos sentimentos, Long id) {
        String query = "UPDATE sentimento(sentimento) VALUES(:sentimento)";

        entityManager.createNativeQuery(query)
                .setParameter("sentimento", sentimentos.getSentimento())
                .setParameter("id", id)
                .executeUpdate();
    }
    @Transactional
    @Override
    public void deletaSentimento(Long id) {
        String query = "DELETE FROM sentimento WHERE id = :id";

        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }
}
