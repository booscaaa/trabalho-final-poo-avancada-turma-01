package br.com.cesurgmarau.trabalho_final.infra.repository.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Comentario.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class ComentarioRepositoryImpl implements ComentarioRepository{

    @Autowired
    private EntityManager entityManager;


    @Transactional
    @Override
    public void create(Comentario comentario) {
        var query = """
                INSERT INTO comentario (texto, sentimento, id_produto, id_usuario)
                VALUES (:texto, :sentimento, :id_produto, :id_usuario);
                """;
        entityManager.createNativeQuery(query)
                .setParameter("texto", comentario.getTexto())
                .setParameter("sentimento", comentario.getSentimento())
                .setParameter("id_produto", comentario.getId_produto())
                .setParameter("id_usuario", comentario.getId_usuario())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void update(int id, Comentario comentario) {
        var query = """
                UPDATE comentario
                SET texto = :texto, sentimento = :sentimento, id_produto = :id_produto, id_usuario = :id_usuario
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query)
                .setParameter("texto", comentario.getTexto())
                .setParameter("sentimento", comentario.getSentimento())
                .setParameter("id_produto", comentario.getId_produto())
                .setParameter("id_usuario", comentario.getId_usuario())
                .setParameter("id", id)
                .executeUpdate();
    }

    @Transactional
    @Override
    public void delete(int id) {
        var query = """
                DELETE FROM comentario
                WHERE id = :id;
                """;
        entityManager.createNativeQuery(query)
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public Comentario findById(int id) {
        var query = """
                SELECT * FROM comentario
                WHERE id = :id;
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
}
