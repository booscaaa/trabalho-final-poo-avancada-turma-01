package br.com.cesurgmarau.trabalho_final.infra.repository.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Ranking.RankingRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.RankingUsuariosDTO;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RankingRepositoryImpl implements RankingRepository {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<RankingUsuariosDTO> rankingUsuarios() {
        var query = """
                SELECT u.nome as usuario, COUNT(*) as positivos
                FROM comentario c
                INNER JOIN usuario u ON u.id = c.id_usuario
                WHERE c.sentimento = 'Positivo' or c.sentimento = 'Muito Positivo'
                GROUP BY usuario
                ORDER BY positivos DESC
               """;
        return entityManager.createNativeQuery(query, RankingUsuariosDTO.class)
                .getResultList();
    }
}
