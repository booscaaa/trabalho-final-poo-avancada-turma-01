package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoDestaqueResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.UsuarioDestaqueResponse;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComentarioRepositoryImpl implements ComentarioRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public Comentario salvar(Comentario comentario) {
        var query = """
            INSERT INTO comentarios (texto, sentimento, usuario_id, produto_id)
            VALUES (:texto, :sentimento, :usuarioId, :produtoId)
        """;
        entityManager.createNativeQuery(query)
                .setParameter("texto", comentario.getTexto())
                .setParameter("sentimento", comentario.getSentimento())
                .setParameter("usuarioId", comentario.getUsuarioId())
                .setParameter("produtoId", comentario.getProdutoId())
                .executeUpdate();

        return comentario;
    }

    @Override
    public Optional<Comentario> buscarPorId(Integer id) {
        var query = "SELECT * FROM comentarios WHERE id = :id";
        List<Comentario> resultado = entityManager
                .createNativeQuery(query, Comentario.class)
                .setParameter("id", id)
                .getResultList();

        return resultado.stream().findFirst();
    }

    @Override
    public List<Comentario> buscarTodos() {
        var query = "SELECT * FROM comentarios";
        return entityManager.createNativeQuery(query, Comentario.class).getResultList();
    }

    @Override
    public List<Comentario> buscarPorProdutoId(Integer produtoId) {
        var query = """
            SELECT * FROM comentarios WHERE produto_id = :produtoId
        """;
        return entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("produtoId", produtoId)
                .getResultList();
    }

    @Override
    public List<Comentario> buscarPorUsuarioId(Integer usuarioId) {
        var query = """
            SELECT * FROM comentarios WHERE usuario_id = :usuarioId
        """;
        return entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("usuarioId", usuarioId)
                .getResultList();
    }

    @Override
    public List<Comentario> buscarPorSentimento(String sentimento) {
        var query = """
            SELECT * FROM comentarios WHERE LOWER(sentimento) LIKE :sentimento
        """;
        return entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("sentimento", "%" + sentimento.toLowerCase() + "%")
                .getResultList();
    }

    @Override
    @Transactional
    public void deletar(Integer id) {
        var query = "DELETE FROM comentarios WHERE id = :id";
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<UsuarioDestaqueResponse> buscarUsuariosComMaisComentariosPositivos() {
        var query = """
            SELECT u.id, u.nome, COUNT(c.*)
            FROM comentarios c
            JOIN usuario u ON u.id = c.usuario_id
            WHERE LOWER(c.sentimento) LIKE '%positivo%'
            GROUP BY u.id, u.nome
            ORDER BY COUNT(c.*) DESC
        """;
        List<Object[]> resultado = entityManager.createNativeQuery(query).getResultList();

        return resultado.stream()
                .map(entry -> new UsuarioDestaqueResponse((Integer) entry[0], (String) entry[1], ((Number) entry[2]).longValue()))
                .toList();
    }

    @Override
    public List<ProdutoDestaqueResponse> buscarProdutosComMaisSentimentosPositivos() {
        var query = """
        SELECT p.id, p.nome, COUNT(*)
        FROM comentarios c
        JOIN produtos p ON p.id = c.produto_id
        WHERE LOWER(c.sentimento) LIKE '%positivo%'
        GROUP BY p.id, p.nome
        ORDER BY COUNT(*) DESC
    """;

        List<Object[]> resultado = entityManager.createNativeQuery(query).getResultList();

        return resultado.stream()
                .map(entry -> new ProdutoDestaqueResponse((Integer) entry[0], (String) entry[1], ((Number) entry[2]).longValue()))
                .toList();
    }

}
