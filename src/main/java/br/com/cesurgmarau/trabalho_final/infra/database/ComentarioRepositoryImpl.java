package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.repository.ComentarioRepository;
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
    @Override
    public void createComentario(Comentario comentario) {
        String query = "INSERT INTO comentario (texto, usuario_id, produto_id, sentimento) VALUES (:texto, :usuario_id, :produto_id, :sentimento)";

        entityManager.createNativeQuery(query)
                .setParameter("texto", comentario.getTexto())
                .setParameter("usuario_id", comentario.getUsuario().getId())
                .setParameter("produto_id", comentario.getProduto().getId())
                .setParameter("sentimento", comentario.getSentimento())
                .executeUpdate();
    }

    @Override
    public List<Comentario> readComentario() {
        String query = "SELECT * FROM comentario";

        return entityManager.createNativeQuery(query, Comentario.class)
                .getResultList();
    }

    @Override
    public Comentario readComentario(Integer id) {
        String query = "SELECT * FROM comentario WHERE id = :id";

        return (Comentario) entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void updateComentario(Integer id, Comentario comentario) {
        String query = "UPDATE comentario SET (texto, usuario_id, produto_id, sentimento) = (:texto, :usuario_id, :produto_id, :sentimento) WHERE id = :id";

        entityManager.createNativeQuery(query)
                .setParameter("texto", comentario.getTexto())
                .setParameter("usuario_id", comentario.getUsuario().getId())
                .setParameter("produto_id", comentario.getProduto().getId())
                .setParameter("sentimento", comentario.getSentimento())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void deleteComentario(Integer id) {
        String query = "DELETE FROM comentario WHERE id = :id";

        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List<Comentario> readComentarioByNullSentimento() {
        String query = "SELECT * FROM comentario WHERE sentimento IS NULL";
        return entityManager.createNativeQuery(query, Comentario.class)
                .getResultList();
    }

    @Override
    public List<Comentario> findByProdutoId(Integer produtoId) {
        String query = "SELECT * FROM comentario WHERE produto_id = :produtoId";
        return entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("produtoId", produtoId)
                .getResultList();
    }

    @Override
    public List<Comentario> findByUsuarioId(Integer usuarioId) {
        String query = "SELECT * FROM comentario WHERE usuario_id = :usuarioId";
        return entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("usuarioId", usuarioId)
                .getResultList();
    }

}
