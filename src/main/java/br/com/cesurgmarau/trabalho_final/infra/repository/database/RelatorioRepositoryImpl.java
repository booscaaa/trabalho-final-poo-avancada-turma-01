package br.com.cesurgmarau.trabalho_final.infra.repository.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorio.RelatorioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.RelatorioSentimentoDTO;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Sentimento;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RelatorioRepositoryImpl implements RelatorioRepository {
    @Autowired
    private EntityManager entityManager;


    @Override
    public List<RelatorioSentimentoDTO> relatorioSentimento() {
        var query = """
                SELECT sentimento, COUNT(*) AS total
                FROM comentario
                GROUP BY sentimento;
                """;
        return entityManager.createNativeQuery(query, RelatorioSentimentoDTO.class)
                .getResultList();
    }

    @Override
    public List<String> totalSentimentosByProduct(int id) {
        var query = """
                SELECT sentimento
                FROM comentario
                WHERE id_produto = :id
                """;
        return entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .getResultList();
    }

}
