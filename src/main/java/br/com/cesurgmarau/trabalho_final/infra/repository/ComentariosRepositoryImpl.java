package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Repository.ComentariosRepository;
import br.com.cesurgmarau.trabalho_final.Core.domain.entity.Comentarios;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
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
                
                INSERT INTO comentarios (produto_id, usuario_id, comentario, avaliacao)
                VALUES (:produto_id, :usuario_id, :comentario, :avaliacao);
                
                """;

        entityManager.createNativeQuery(query, Comentarios.class)
                .setParameter("produto_id", comentario.getProdutoId())
                .setParameter("usuario_id", comentario.getUsuarioId())
                .setParameter("comentario", comentario.getComentario())
                .setParameter("avaliacao", comentario.getAvaliacao())
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
                
                DELETE FROM comentaiors WHERE id = :id
                
                """;

        entityManager.createNativeQuery(query, Comentarios.class)
                .setParameter("id", id)
                .executeUpdate();

        System.out.println("Comentario excluído com sucesso!");

    }
}
