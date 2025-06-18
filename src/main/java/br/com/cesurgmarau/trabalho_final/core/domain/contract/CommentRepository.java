package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comment;

import java.util.List;

public interface CommentRepository {
    public String createComment(Comment comment);

    public List<Comment> getAllComment();

    public List<Comment> listCommentsByUserID(int id);
    public List<Comment> listCommentsByFeelingID(int id);
    public List<Comment> listCommentsByProductID(int id);

    public Comment listCommentByID(int id);

    public String updateComment(int id, Comment comment);

    public String deleteComment(int id);
}
