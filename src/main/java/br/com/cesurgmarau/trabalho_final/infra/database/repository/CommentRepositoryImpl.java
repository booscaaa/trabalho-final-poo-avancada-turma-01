package br.com.cesurgmarau.trabalho_final.infra.database.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.CommentRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comment;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepositoryImpl implements CommentRepository {
        @PersistenceContext
        private EntityManager entityManager;


        @Transactional
        @Override
        public String deleteComment(int id) {
            var query = "DELETE FROM comment WHERE id = :id";

            entityManager.createNativeQuery(query, Comment.class).setParameter("id", id).executeUpdate();
            return "Comentario deletado com sucesso!";
        }

    @Override
    public String updateComment(int id, Comment comment) {
        return "";
    }

    @Override
        public List<Comment> listAllComments() {
            var query = "SELECT * FROM comment";

            return (List<Comment>) entityManager.createNativeQuery(query, Comment.class).getResultList();
        }

        @Override
        public Comment listByID(int id) {
            var query = "SELECT * FROM comment WHERE id = :id";

            return (Comment) entityManager.createNativeQuery(query, Comment.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }

    @Override
    public void createComment(Comment comment) {
        var query = """
                INSERT INTO comment (curso_id, disciplina_id)
                VALUES (:curso_id, :disciplina)
                """;
        entityManager.createNativeQuery(query, CursoDisciplina.class)
                .setParameter("curso_id", cursoDisciplina.getCurso_id())
                .setParameter("disciplina_id", cursoDisciplina.getDisciplina_id())
                .executeUpdate();
    }
}
