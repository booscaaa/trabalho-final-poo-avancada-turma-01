package br.com.cesurgmarau.trabalho_final.infra.repository.usuario;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorios.RelatoriosUsuario.RelatoriosUsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.dto.RankingUsuarioOutput.RankingUsuarioOutput;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

import static sun.security.krb5.Confounder.intValue;

@Repository
public class RelatoriosUsuarioRepositoryImpl implements RelatoriosUsuarioRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<RankingUsuarioOutput> rankingAtividadeUsuarios() {

        var query = """
                
                SELECT
                
                    RANK() OVER (ORDER BY COUNT(*) DESC) AS posicao,
                    u.nome AS usuario,
                    COUNT(*) AS quantidade_comentarios
                    
                FROM comentarios c
                INNER JOIN usuarios u ON u.id = c.usuario_id
                GROUP BY u.id, u.nome
                ORDER BY posicao;
                
                """;

        return entityManager.createNativeQuery(query, "UsuarioMaisAtivoMapping")
                .getResultList();
    }
}
