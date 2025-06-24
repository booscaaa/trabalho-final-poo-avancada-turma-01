package br.com.cesurgmarau.trabalho_final.infra.repository.comentario;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorios.RelatoriosComentario.RelatorioComentRepository;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentariosPorSentimentoOutput.ComentarioPorSentimentoOutput;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RelatorioComentRepositoryImpl implements RelatorioComentRepository {

    @Autowired
    EntityManager entityManager;


    @Override
    public List<ComentarioPorSentimentoOutput> listaTotalComentariosPorSentimento() {

        var query = """
                
                SELECT
                    CASE
                        WHEN c.sentimento IS NULL THEN 'desconhecido'
                        ELSE c.sentimento
                    END AS sentimento,
                    COUNT(*) AS quantidade_comentarios
                FROM comentarios c
                GROUP BY
                    CASE
                        WHEN c.sentimento IS NULL THEN 'desconhecido'
                        ELSE c.sentimento
                    END;
                
                """;

        return entityManager.createNativeQuery(query, "ComentarioPorSentimentoOutputMapping")
                .getResultList();

    }
}
