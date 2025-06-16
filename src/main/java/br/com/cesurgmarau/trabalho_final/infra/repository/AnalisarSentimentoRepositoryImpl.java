package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Repository.AnalisarSentimentoRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AnalisarSentimentoRepositoryImpl implements AnalisarSentimentoRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<AnalisarSentimento> fetch() {
        var query = """
                
                SELECT * FROM analisar_sentimento;
                
                
                """;
        return (List<AnalisarSentimento>) entityManager.createNativeQuery(query, AnalisarSentimento.class).getResultList();

    }

    @Override
    public AnalisarSentimento fetchById(int id) {

        var query = """
                
                SELECT * FROM analisar_sentimento where id = :id
                
                """;


        return (AnalisarSentimento) entityManager.createNativeQuery(query, AnalisarSentimento.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void createAnaliseDeSentimento(AnalisarSentimento analisarSentimento) {

        var query = """
                
                INSERT INTO analisar_sentimento (sentimento, analise, comentario_id)
                VALUES (:sentimento, :analise, :comentario_id);
                
                """;

        entityManager.createNativeQuery(query, AnalisarSentimento.class)
                .setParameter("sentimento", analisarSentimento.getSentimento())
                .setParameter("analise", analisarSentimento.getAnalise())
                .setParameter("comentario_id", analisarSentimento.getComentarioId())
                .executeUpdate();

        System.out.println("Analise postada com sucesso!");

    }

    @Transactional
    @Override
    public void updateAnaliseDeSentimento(AnalisarSentimento analisarSentimento, int id) {

        var query = """
                
                UPDATE analisar_sentimento SET
                sentimento = :sentimento,
                analise = :analise,
                comentario_id = :comentario_id
                WHERE id = :id
                
                """;

        entityManager.createNativeQuery(query, br.com.cesurgmarau.trabalho_final.Core.domain.entity.Comentarios.class)
                .setParameter("id", id)
                .setParameter("sentimento", analisarSentimento.getSentimento())
                .setParameter("analise", analisarSentimento.getAnalise())
                .setParameter("comentario_id", analisarSentimento.getComentarioId())
                .executeUpdate();

        System.out.println("Analise atualizada com sucesso!");

    }

    @Transactional
    @Override
    public void deleteAnaliseDeSentimento(int id) {

        var query = """
                
                DELETE FROM analisar_sentimento WHERE id = :id
                
                """;

        entityManager.createNativeQuery(query, AnalisarSentimento.class)
                .setParameter("id", id)
                .executeUpdate();

        System.out.println("Analise excluída com sucesso!");

    }
}
