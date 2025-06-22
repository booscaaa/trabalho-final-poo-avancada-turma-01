package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoDestaqueResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.UsuarioDestaqueResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComentarioRepositoryImpl implements ComentarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Comentario salvar(Comentario comentario) {
        entityManager.persist(comentario);
        return comentario;
    }

    @Override
    public Optional<Comentario> buscarPorId(Integer id) {
        return Optional.ofNullable(entityManager.find(Comentario.class, id));
    }

    @Override
    public List<Comentario> buscarTodos() {
        return entityManager
                .createQuery("SELECT c FROM Comentario c", Comentario.class)
                .getResultList();
    }

    @Override
    public List<Comentario> buscarPorProdutoId(Integer produtoId) {
        return entityManager.createQuery(
                        "SELECT c FROM Comentario c WHERE c.produtoId = :produtoId", Comentario.class
                )
                .setParameter("produtoId", produtoId)
                .getResultList();
    }

    @Override
    public List<Comentario> buscarPorUsuarioId(Integer usuarioId) {
        return entityManager.createQuery(
                        "SELECT c FROM Comentario c WHERE c.usuarioId = :usuarioId", Comentario.class
                )
                .setParameter("usuarioId", usuarioId)
                .getResultList();
    }

    @Override
    public List<Comentario> buscarPorSentimento(String sentimento) {
        return entityManager.createQuery(
                        "SELECT c FROM Comentario c WHERE c.sentimento = :sentimento", Comentario.class
                )
                .setParameter("sentimento", sentimento)
                .getResultList();
    }

    @Override
    @Transactional
    public void deletar(Integer id) {
        Comentario comentario = entityManager.find(Comentario.class, id);
        if (comentario != null) {
            entityManager.remove(comentario);
        }
    }

    @Override
    public List<UsuarioDestaqueResponse> buscarUsuariosComMaisComentariosPositivos() {
        String jpql = """
            SELECT new br.com.cesurgmarau.trabalho_final.core.dto.UsuarioDestaqueResponse(
                u.id, u.nome, COUNT(c)
            )
            FROM Comentario c
            JOIN Usuario u ON u.id = c.usuarioId
            WHERE LOWER(c.sentimento) LIKE '%positivo%'
            GROUP BY u.id, u.nome
            ORDER BY COUNT(c) DESC
        """;

        TypedQuery<UsuarioDestaqueResponse> query = entityManager.createQuery(jpql, UsuarioDestaqueResponse.class);
        return query.getResultList();
    }

    @Override
    public List<ProdutoDestaqueResponse> buscarProdutosComMaisSentimentosPositivos() {
        String jpql = """
            SELECT new br.com.cesurgmarau.trabalho_final.core.dto.ProdutoDestaqueResponse(
                p.id, p.nome, COUNT(c)
            )
            FROM Comentario c
            JOIN Produto p ON p.id = c.produtoId
            WHERE LOWER(c.sentimento) LIKE '%positivo%'
            GROUP BY p.id, p.nome
            ORDER BY COUNT(c) DESC
        """;

        TypedQuery<ProdutoDestaqueResponse> query = entityManager.createQuery(jpql, ProdutoDestaqueResponse.class);
        return query.getResultList();
    }
}
