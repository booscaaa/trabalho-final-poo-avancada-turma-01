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
    public String createComment(Comment comment) {
        var query = "INSERT INTO comments (description, product_id, feeling_id, user_id) VALUES (:description, :product_id, :feeling_id, :user_id );";

        entityManager.createNativeQuery(query, Comment.class)
                .setParameter("description", comment.getDescription())
                .setParameter("product_id", comment.getProduct_id())
                .setParameter("feeling_id", comment.getFeeling_id())
                .setParameter("user_id", comment.getUser_id())
                .executeUpdate();

        return "comentario criado com sucesso";

    }

    @Override
    public List<Comment> getAllComment() {
        var query = "SELECT * FROM comments;";

        return (List<Comment>) entityManager.createNativeQuery(query, Comment.class).getResultList();
    }

    @Override
    public Comment listCommentByID(int id) {
        var query = "SELECT * FROM comments WHERE id = :id";

        return (Comment) entityManager.createNativeQuery(query, Comment.class)
                .setParameter("id", id)
                .getSingleResult();

    }

    @Override
    public List<Comment> listCommentsByUserID(int id) {
        var query = "SELECT * FROM comments WHERE user_id = :id";

        return entityManager.createNativeQuery(query, Comment.class)
                .setParameter("id", id)
                .getResultList();

    }
    @Override
    public List<Comment> listCommentsByProductID(int id) {
        var query = "SELECT * FROM comments WHERE product_id = :id";

        return entityManager.createNativeQuery(query, Comment.class)
                .setParameter("id", id)
                .getResultList();

    }

    @Override
    public List<Comment> listCommentsByFeelingID(int id) {
        var query = "SELECT * FROM comments WHERE feeling_id = :id";

        return entityManager.createNativeQuery(query, Comment.class)
                .setParameter("id", id)
                .getResultList();

    }

    @Transactional
    @Override
    public String updateComment(int id, Comment comment) {
        var query = "UPDATE comments SET description = :description, product_id = :product_id, feeling_id = :feeling_id, user_id = :user_id WHERE id = :id";

        entityManager.createNativeQuery(query, Comment.class)
                .setParameter("description", comment.getDescription())
                .setParameter("product_id", comment.getProduct_id())
                .setParameter("feeling_id", comment.getFeeling_id())
                .setParameter("user_id", comment.getUser_id())
                .setParameter("id", id)
                .executeUpdate();
        return "comentario alterado com sucesso!";
    }

    @Transactional
    @Override
    public String deleteComment(int id) {
        var query = "DELETE FROM comments WHERE id = :id";

        entityManager.createNativeQuery(query, Comment.class).setParameter("id", id).executeUpdate();
        return "comentario deletado com sucesso!";
    }
}
