package br.com.cesurgmarau.trabalho_final.infra.repository.dataBase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.SentimentoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Sentimento;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SentimentoRepositoryImpl implements SentimentoRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Sentimento pegarSentimentoId(String tipoSentimento) {
        var query = """
                SELECT * FROM sentimento WHERE tipo = :tipoSentimento;
                """;
        return (Sentimento) entityManager.createNativeQuery(query, Sentimento.class)
                .setParameter("tipoSentimento", tipoSentimento)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void atualizarSentimento(int id,Sentimento sentimento) {
        var query = """
                UPDATE sentimento SET
                tipo = :tipo,
                quantidade = :quantidade,
                ponto = :ponto
                WHERE id = :id
                """;
        entityManager.createNativeQuery(query, Usuario.class)
                .setParameter("tipo", sentimento.getTipo())
                .setParameter("quantidade", sentimento.getQuantidade())
                .setParameter("ponto", sentimento.getPonto())
                .setParameter("id", id)
                .executeUpdate();
    }
}
