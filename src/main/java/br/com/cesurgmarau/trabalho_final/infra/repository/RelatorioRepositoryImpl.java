package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.RelatorioRepository;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioSentimentosResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioUsuarioResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioProdutoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class RelatorioRepositoryImpl implements RelatorioRepository {

    @Autowired
    private final ComentarioRepository comentarioRepository;

    @Autowired
    private EntityManager entityManager;

    public RelatorioRepositoryImpl(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public List<RelatorioSentimentosResponse> totalComentariosPorSentimento() {
        String query = """
            SELECT sentimento, COUNT(*) 
            FROM comentarios 
            GROUP BY sentimento
        """;

        List<Object[]> resultado = entityManager.createNativeQuery(query).getResultList();

        return resultado.stream()
                .map(entry -> new RelatorioSentimentosResponse((String) entry[0], ((Number) entry[1]).longValue()))
                .toList();
    }

    @Override
    public List<RelatorioProdutoResponse> mediaSentimentoPorProduto() {
        String query = """
            SELECT produto_id,
                   AVG(
                       CASE LOWER(sentimento)
                           WHEN 'muito negativo' THEN 1
                           WHEN 'negativo' THEN 2
                           WHEN 'neutro' THEN 3
                           WHEN 'positivo' THEN 4
                           WHEN 'muito positivo' THEN 5
                           ELSE 3
                       END
                   ) AS media_pontuacao
            FROM comentarios
            GROUP BY produto_id
        """;

        List<Object[]> resultado = entityManager.createNativeQuery(query).getResultList();

        return resultado.stream()
                .map(entry -> new RelatorioProdutoResponse(
                        (Integer) entry[0],
                        ((BigDecimal) entry[1]).doubleValue()
                ))
                .toList();
    }

    @Override
    public List<RelatorioUsuarioResponse> rankingUsuariosMaisAtivos() {
        String query = """
            SELECT usuario_id, COUNT(*) 
            FROM comentarios 
            GROUP BY usuario_id
            ORDER BY COUNT(*) DESC
        """;

        List<Object[]> resultado = entityManager.createNativeQuery(query).getResultList();

        return resultado.stream()
                .map(entry -> new RelatorioUsuarioResponse((Integer) entry[0], ((Number) entry[1]).longValue()))
                .toList();
    }
}
