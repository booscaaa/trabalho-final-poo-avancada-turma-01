package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comment;

import java.util.List;

public interface CommentRepository {
    public List<Comment> listAllComments ();
    public Comment listByID (int id);
    public void createComment (Comment comment);
    public String deleteComment (int id);
    public String updateComment (int id, Comment comment);
}
