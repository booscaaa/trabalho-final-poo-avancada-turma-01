package br.com.cesurgmarau.trabalho_final.infra.repository.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorio.RelatorioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.RelatorioSentimentoDTO;
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
}
