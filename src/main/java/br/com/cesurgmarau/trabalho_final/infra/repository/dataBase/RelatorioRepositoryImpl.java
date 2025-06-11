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
                SELECT (quantidade * 100.0) / (SELECT SUM(quantidade) FROM sentimento
                    ) AS percentual
                FROM sentimento
                WHERE id = :sentimento_id
                """;

        Object result = entityManager.createNativeQuery(query)
                .setParameter("sentimento_id", sentimentoId)
                .getSingleResult();

        return result != null ? ((Number) result).doubleValue() : 0.0;
    }

    @Override
    public double listarPorcentagemDeComentarioPorProdutoId(int produtoId, int sentimentoId) {
        var query = """
                SELECT (COUNT(*) * 100.0) / (SELECT COUNT(*) FROM comentario WHERE produto_id = :produto_id
                    ) AS percentual
                FROM comentario
                WHERE produto_id = :produto_id AND sentimento_id = :sentimento_id
                """;

        Object result = entityManager.createNativeQuery(query)
                .setParameter("produto_id", produtoId)
                .setParameter("sentimento_id", sentimentoId)
                .getSingleResult();

        return result != null ? ((Number) result).doubleValue() : 0.0;
    }


}
