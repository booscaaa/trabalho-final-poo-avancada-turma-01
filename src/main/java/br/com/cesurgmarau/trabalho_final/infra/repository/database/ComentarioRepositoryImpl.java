package br.com.cesurgmarau.trabalho_final.infra.repository.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ComentarioRepositoryImpl implements ComentarioRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public Comentario insert(Comentario comentario) {
        var query = """
                INSERT INTO comentario (texto, livro_id, usuario_id)
                VALUES (:texto, :livroId, :usuarioId);
                """;
        entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("texto", comentario.getTexto())
                .setParameter("livroId", comentario.getLivroId())
                .setParameter("usuarioId", comentario.getUsuarioId())
                .executeUpdate();
        return comentario;
    }

    @Transactional
    public void update(int id, Comentario comentario) {
        var query = """
                UPDATE comentario SET 
                texto = :texto, livro_id = :livroId, usuario_id = :usuarioId
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("texto", comentario.getTexto())
                .setParameter("livroId", comentario.getLivroId())
                .setParameter("usuarioId", comentario.getUsuarioId())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    public void delete(int id) {
        var query = "DELETE FROM comentario WHERE id = :id";
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }
    public List<Comentario> buscarTodosOsComentarios() {
        var query = "SELECT * FROM comentario;";
        return entityManager.createNativeQuery(query, Comentario.class)
                .getResultList();
    }

    public Comentario buscarComentarioPorId(int id) {
        var query = "SELECT * FROM comentario WHERE id = :id;";
        try {
            return (Comentario) entityManager.createNativeQuery(query, Comentario.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    public List<Comentario> buscarProdutoPorId(int livroId) {
        var query = "SELECT * FROM comentario WHERE livro_id = :livro_id";
        return entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("livro_id", livroId)
                .getResultList();
    }


    @Override
    public List<Comentario> buscarUsuarioPorId(int usuarioId) {
        var query = "SELECT * FROM comentario WHERE usuario_id = :usuario_id";
        return entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("usuario_id", usuarioId)
                .getResultList();
    }

    @Override
    public List<Comentario> buscarTodos() {
        return List.of();
    }

}
