package br.com.cesurgmarau.trabalho_final.infra.repository.comentario;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.CRUD.ComentarioCRUDRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

import java.util.List;

public class ComentarioCRUDRepositoryImpl implements ComentarioCRUDRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Comentario> fetch() {
        var query = """
                
                SELECT * FROM comentarios;
                
                
                """;
        return (List<Comentario>) entityManager.createNativeQuery(query, Comentario.class).getResultList();

    }

    @Override
    public Comentario fetchById(int id) {

        var query = """
                
                SELECT * FROM comentarios where id = :id
                
                """;


        return (Comentario) entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void createComentario(Comentario comentario) {

        var query = """
                
                INSERT INTO comentarios (produto_id, usuario_id, comentario, avaliacao)
                VALUES (:produto_id, :usuario_id, :comentario, :avaliacao);
                
                """;

        entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("produto_id", comentario.getProdutoId())
                .setParameter("usuario_id", comentario.getUsuarioId())
                .setParameter("comentario", comentario.getComentario())
                .setParameter("avaliacao", comentario.getAvaliacao())
                .executeUpdate();

        System.out.println("Comentario postado com sucesso!");

    }

    @Transactional
    @Override
    public void updateComentario(Comentario comentario, int id) {

        var query = """
                
                UPDATE FROM comentarios SET
                produto_id = :produto_id
                usuario_id = :usuario_id
                comentario = :comentario
                avaliacao = :avaliacao
                WHERE id = :id
                
                """;

        entityManager.createNativeQuery(query, Comentario.class)
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

        entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("id", id)
                .executeUpdate();

        System.out.println("Comentario excluído com sucesso!");

    }
}
