package br.com.cesurgmarau.trabalho_final.infra.repository.dataBase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.RelatorioRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RelatorioRepositoryImpl implements RelatorioRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public double listarPorcentagemDeComentario(int sentimentoId) {
        var query = """
                    SELECT (s.quantidade * 100.0) / t.total AS percentual
                    FROM sentimento s
                    INNER JOIN (
                        SELECT SUM(quantidade) AS total FROM sentimento
                    ) t ON 1=1
                    WHERE s.id = :sentimento_id
                """;

        Object result = entityManager.createNativeQuery(query)
                .setParameter("sentimento_id", sentimentoId)
                .getSingleResult();

        return result != null ? ((Number) result).doubleValue() : 0.0;
    }

    @Override
    public double listarPorcentagemDeComentarioPorProdutoId(int produtoId, int sentimentoId) {
        var query = """
                SELECT (COUNT(*) * 100.0) / MIN(p.quantidade_comentario) AS percentual FROM comentario c
                INNER JOIN produto p ON p.id = c.produto_id
                WHERE c.produto_id = :produto_id AND c.sentimento_id = :sentimento_id
                """;

        Object result = entityManager.createNativeQuery(query)
                .setParameter("produto_id", produtoId)
                .setParameter("sentimento_id", sentimentoId)
                .getSingleResult();

        return result != null ? ((Number) result).doubleValue() : 0.0;
    }


}
