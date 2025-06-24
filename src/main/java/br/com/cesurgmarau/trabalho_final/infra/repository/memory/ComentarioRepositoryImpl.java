package br.com.cesurgmarau.trabalho_final.infra.repository.memory;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Repository
public class ComentarioRepositoryImpl implements ComentarioRepository {

    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public void adicionarComentario(Comentario comentario) {
        var query = """
            INSERT INTO comentarios ( id_usuario, id_produto, texto, sentimento)
            VALUES (:id_usuario, :id_produto, :texto, :sentimento)
            """;

        entityManager.createNativeQuery(query)
                .setParameter("id_usuario", comentario.getId_usuario())
                .setParameter("id_produto", comentario.getId_produto())
                .setParameter("texto", comentario.getTexto())
                .setParameter("sentimento", comentario.getSentimento())
                .executeUpdate();
    }

    @Transactional
    @Override
    public String atualizarComentario(int id, Comentario comentario) {
        var query = """
                UPDATE comentarios SET
                id_usuario = :id_usuario,
                id_produto = :id_produto,
                texto = :texto,
                sentimento = :sentimento
                WHERE id = :id
                """;

        entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("id_usuario", comentario.getId_usuario())
                .setParameter("id_produto", comentario.getId_produto())
                .setParameter("texto", comentario.getTexto())
                .setParameter("sentimento", comentario.getSentimento())
                .setParameter("id", id)
                .executeUpdate();

        return "Comentário atualizado com sucesso!";
    }

    @Transactional
    @Override
    public String deletarComentario(int id) {
        var query = "DELETE FROM comentarios WHERE id = :id";

        entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("id", id)
                .executeUpdate();

        return "Comentário removido com sucesso!";
    }

    @Override
    public List<Comentario> listar() {
        var query = "SELECT * FROM comentarios";

        return (List<Comentario>) entityManager
                .createNativeQuery(query, Comentario.class)
                .getResultList();
    }

    @Override
    public Comentario listarPorId(int id) {
        var query = "SELECT * FROM comentarios WHERE id = :id";

        return (Comentario) entityManager
                .createNativeQuery(query, Comentario.class)
                .setParameter("id", id)
                .getSingleResult();
    }
    @Override
    public List<Comentario> findAll() {
        return listar(); // Reutiliza o método listar()
    }

}
