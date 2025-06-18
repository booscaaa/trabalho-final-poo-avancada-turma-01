package br.com.cesurgmarau.trabalho_final.core.UseCase.impl;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.CommentRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.CommentUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentUseCaseImpl implements CommentUseCase {
    @Autowired
    private CommentRepository repository;
    private Comment comment;


    @Override
    public String createComment(Comment comment) {
        return repository.createComment(comment);
    }

    @Override
    public List<Comment> getAllComment() {
        return repository.getAllComment();
    }

    @Override
    public List<Comment> listCommentsByUserID(int id) {
        return repository.listCommentsByUserID(id);
    }
    @Override
    public List<Comment> listCommentsByProductID(int id) {
        return repository.listCommentsByProductID(id);
    }
    @Override
    public List<Comment> listCommentsByFeelingID(int id) {
        return repository.listCommentsByFeelingID(id);
    }

    @Override
    public Comment listCommentByID(int id) {
        return repository.listCommentByID(id);
    }


    @Override
    public String updateComment(int id, Comment comment) {
        return repository.updateComment(id, comment);
    }

    @Override
    public String deleteComment(int id) {
        return repository.deleteComment(id);
    }
}
