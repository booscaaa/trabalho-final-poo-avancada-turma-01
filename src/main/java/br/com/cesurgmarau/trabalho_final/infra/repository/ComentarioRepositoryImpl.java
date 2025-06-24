package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.repository.ComentarioRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComentarioRepositoryImpl implements ComentarioRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public void insert(Comentario comentario) {
        var query = """
                INSERT INTO comentario (descricao, produto_id, sentimento_id, usuario_id)
                VALUES (:descricao, :produto_id, :sentimento_id, :usuario_id);
                """;
        entityManager.createNativeQuery(query)
                .setParameter("descricao", comentario.getDescricao())
                .setParameter("produto_id", comentario.getProduto_id())
                .setParameter("sentimento_id", comentario.getSentimento_id())
                .setParameter("usuario_id", comentario.getUsuario_id())
                .executeUpdate();
    }

    @Override
    @Transactional
    public void update(int id, Comentario comentario) {
        var query = """
                UPDATE comentario 
                SET descricao = :descricao, 
                    produto_id = :produto_id, 
                    sentimento_id = :sentimento_id, 
                    usuario_id = :usuario_id
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query)
                .setParameter("descricao", comentario.getDescricao())
                .setParameter("produto_id", comentario.getProduto_id())
                .setParameter("sentimento_id", comentario.getSentimento_id())
                .setParameter("usuario_id", comentario.getUsuario_id())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void delete(int id) {
        var query = """
                DELETE FROM comentario WHERE id = :id;
                """;
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Comentario getById(int id) {
        var query = """
                SELECT * FROM comentario WHERE id = :id;
                """;
        return (Comentario) entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Comentario> fetch() {
        var query = """
                SELECT * FROM comentario;
                """;
        return entityManager.createNativeQuery(query, Comentario.class)
                .getResultList();
    }

    @Override
    public List<Comentario> getByProdutoId(int produto_id) {
        var query = """
                SELECT * FROM comentario WHERE produto_id = :produto_id;
                """;
        return entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("produto_id", produto_id)
                .getResultList();
    }

    @Override
    public List<Comentario> getByUsuarioId(int usuario_id) {
        var query = """
                SELECT * FROM comentario WHERE usuario_id = :usuario_id;
                """;
        return entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("usuario_id", usuario_id)
                .getResultList();
    }

    @Override
    public List<Comentario> getBySentimento(int sentimento_id) {
        var query = """
                SELECT * FROM comentario WHERE sentimento_id = :sentimento_id;
                """;
        return entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("sentimento_id", sentimento_id)
                .getResultList();
    }
}
