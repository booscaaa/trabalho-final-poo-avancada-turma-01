package br.com.cesurgmarau.trabalho_final.infra.repository.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComentarioRepositoryImpl implements ComentarioRepository {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public void insert(Comentario comentario) {
        var query = """
                INSERT INTO comentario (texto, livro_id, usuario_id)
                VALUES (:texto, :livroId, :usuarioId);
                """;
        entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("texto", comentario.getTexto())
                .setParameter("livroId", comentario.getLivroId())
                .setParameter("usuarioId", comentario.getUsuarioId())
                .executeUpdate();
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
        entityManager.createNativeQuery(query).setParameter("id", id).executeUpdate();
    }

    public List<Comentario> fetch() {
        var query = "SELECT * FROM comentario;";
        return entityManager.createNativeQuery(query, Comentario.class).getResultList();
    }

    public Comentario get(int id) {
        var query = "SELECT * FROM comentario WHERE id = :id;";
        return (Comentario) entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("id", id)
                .getSingleResult();
    }



}
