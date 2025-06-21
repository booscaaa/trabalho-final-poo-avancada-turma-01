package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.RelatorioContracts.RelatorioRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Transactional
@Repository
public class RelatorioRepositoryImpl implements RelatorioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Objects[]> relatorioSentimentos() {
        var query = """
            SELECT sentimento_nota, COUNT(*)
            FROM comentarios
            WHERE sentimento_nota IS NOT NULL
            GROUP BY sentimento_nota
            ORDER BY sentimento_nota DESC
        """;

        return entityManager.createNativeQuery(query)
                .getResultList();
    }

    @Override
    public List<Object[]> mediaProdutos() {
        var query = """
            SELECT p.nome, ROUND(AVG(c.sentimento_nota), 4) AS media
            FROM comentarios c
            JOIN produtos p ON p.id_produto = c.produto
            WHERE c.sentimento_nota IS NOT NULL
            GROUP BY p.nome
            ORDER BY media DESC;
        """;

        return entityManager.createNativeQuery(query).getResultList();
    }

    @Override
    public List<Object[]> usuarioMaisAtivo() {
        var query = """
           SELECT u.nome, COUNT(*) AS total_comentarios
           FROM comentarios c
           JOIN usuarios u ON u.id_usuario = c.usuario
           GROUP BY u.nome
           ORDER BY total_comentarios DESC;
        """;

        return entityManager.createNativeQuery(query).getResultList();
    }
}
