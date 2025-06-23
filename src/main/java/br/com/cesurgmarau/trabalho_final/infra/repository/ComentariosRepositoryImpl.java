package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.DTO.UsuarioRankingDTO;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Repository.ComentariosRepository;
import br.com.cesurgmarau.trabalho_final.Core.domain.entity.Comentarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ComentariosRepositoryImpl implements ComentariosRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Comentarios> fetch() {
        var query = """
                
                SELECT * FROM comentarios;
                
                
                """;
        return (List<Comentarios>) entityManager.createNativeQuery(query, Comentarios.class).getResultList();

    }

    @Override
    public Comentarios fetchById(int id) {

        var query = """
                
                SELECT * FROM comentarios where id = :id
                
                """;


        return (Comentarios) entityManager.createNativeQuery(query, Comentarios.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void createComentario(Comentarios comentario) {

        var query = """
                
                INSERT INTO comentarios (produto_id, usuario_id, comentario, avaliacao, sentimento)
                VALUES (:produto_id, :usuario_id, :comentario, :avaliacao, :sentimento);
                
                """;

        entityManager.createNativeQuery(query, Comentarios.class)
                .setParameter("produto_id", comentario.getProdutoId())
                .setParameter("usuario_id", comentario.getUsuarioId())
                .setParameter("comentario", comentario.getComentario())
                .setParameter("avaliacao", comentario.getAvaliacao())
                .setParameter("sentimento", comentario.getSentimento())
                .executeUpdate();

        System.out.println("Comentario postado com sucesso!");

    }

    @Transactional
    @Override
    public void updateComentario(Comentarios comentario, int id) {

        var query = """
                
                UPDATE comentarios SET
                produto_id = :produto_id,
                usuario_id = :usuario_id,
                comentario = :comentario,
                avaliacao = :avaliacao
                WHERE id = :id
                
                """;

        entityManager.createNativeQuery(query, Comentarios.class)
                .setParameter("id", id)
                .setParameter("produto_id", comentario.getProdutoId())
                .setParameter("usuario_id", comentario.getUsuarioId())
                .setParameter("comentario", comentario.getComentario())
                .setParameter("avaliacao", comentario.getAvaliacao())
                .executeUpdate();

        System.out.println("Comentarios atualizado com sucesso!");

    }

    @Transactional
    @Override
    public void deleteComentario(int id) {

        var query = """
                
                DELETE FROM comentarios WHERE id = :id
                
                """;

        entityManager.createNativeQuery(query, Comentarios.class)
                .setParameter("id", id)
                .executeUpdate();

        System.out.println("Comentario excluído com sucesso!");

    }
    public Map<String, Long> totalComentariosPorSentimento() {
        String query = "SELECT sentimento, COUNT(*) FROM comentarios GROUP BY sentimento";

        List<Object[]> results = entityManager.createNativeQuery(query).getResultList();
        Map<String, Long> map = new HashMap<>();
        for (Object[] row : results) {
            map.put((String) row[0], ((Number) row[1]).longValue());
        }
        return map;
    }

    @Override
    public Map<String, Double> mediaSentimentoPorProduto() {
        String query = """
        SELECT p.name, AVG(
            CASE c.sentimento
                WHEN 'muito negativo' THEN 1
                WHEN 'negativo' THEN 2
                WHEN 'neutro' THEN 3
                WHEN 'positivo' THEN 4
                WHEN 'muito positivo' THEN 5
                ELSE 3
            END
        ) as media
        FROM comentarios c
        JOIN produtos p ON c.produto_id = p.id
        GROUP BY p.name
        """;

        List<Object[]> results = entityManager.createNativeQuery(query).getResultList();
        Map<String, Double> map = new HashMap<>();
        for (Object[] row : results) {
            map.put((String) row[0], ((Number) row[1]).doubleValue());
        }
        return map;
    }

    @Override
    public List<UsuarioRankingDTO> rankingUsuariosMaisAtivos() {
        String query = """
        SELECT u.name, COUNT(*) as total
        FROM comentarios c
        JOIN usuarios u ON c.usuario_id = u.id
        GROUP BY u.name
        ORDER BY total DESC
        """;

        List<Object[]> results = entityManager.createNativeQuery(query).getResultList();
        List<UsuarioRankingDTO> ranking = new ArrayList<>();
        for (Object[] row : results) {
            UsuarioRankingDTO dto = new UsuarioRankingDTO();
            dto.setNome((String) row[0]);
            dto.setTotalComentarios(((Number) row[1]).longValue());
            ranking.add(dto);
        }
        return ranking;
    }
    @Override
    public List<Comentarios> buscarPorSentimento(String sentimento) {
        String query = "SELECT * FROM comentarios WHERE sentimento = :sentimento";

        return entityManager.createNativeQuery(query, Comentarios.class)
                .setParameter("sentimento", sentimento)
                .getResultList();
    }







}
