package br.com.cesurgmarau.trabalho_final.infra.repository.comentario;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.CRUD.ComentarioCRUDRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.produto.AvaliacaoProduto.AvaliacaoMediaRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComentarioCRUDRepositoryImpl implements ComentarioCRUDRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    AvaliacaoMediaRepository avaliacaoMediaRepository;

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
    public void createComentario(Comentario comentario, int produtoID) {

        String query = """
            INSERT INTO comentarios (produto_id, usuario_id, comentario, avaliacao, analise, sentimento)
            VALUES (:produto_id, :usuario_id, :comentario, :avaliacao, :analise, :sentimento);
            """;

        entityManager.createNativeQuery(query)
                .setParameter("produto_id", produtoID)
                .setParameter("usuario_id", comentario.getUsuarioId())
                .setParameter("comentario", comentario.getComentario())
                .setParameter("avaliacao", comentario.getAvaliacao())
                .setParameter("analise", comentario.getAnalise())
                .setParameter("sentimento", comentario.getSentimento())
                .executeUpdate();

        System.out.println("Comentário postado com sucesso!");
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
                
                DELETE FROM comentarios WHERE id = :id
                
                """;

        entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("id", id)
                .executeUpdate();

        System.out.println("Comentario excluído com sucesso!");

    }
}
