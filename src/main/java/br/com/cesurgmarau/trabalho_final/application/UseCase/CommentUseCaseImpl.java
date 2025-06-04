package br.com.cesurgmarau.trabalho_final.application.UseCase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.CommentUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comment;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommentUseCaseImpl implements CommentUseCase {

    @Override
    public List<Comment> listAllComments() {
        return List.of();
    }

    @Override
    public Comment listByID(int id) {
        return null;
    }

    @Override
    public void createComment(Comment comment) {

    }

    @Override
    public String deleteComment(int id) {
        return "";
    }

    @Override
    public String updateComment(int id, Comment comment) {
        return "";
    }
}
