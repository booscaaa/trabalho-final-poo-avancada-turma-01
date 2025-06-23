package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.CommentUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    CommentUseCase commentUseCase;

    @PostMapping("/comment")
    public String createComment(@RequestBody Comment comment) {
        commentUseCase.createComment(comment);
        return "comentario criado com sucesso!";
    }

    @PutMapping("/comment/{id}")
    public String updateComment(@PathVariable int id, @RequestBody Comment comment) {
        commentUseCase.updateComment(id, comment);
        return "comentario alterado com sucesso!";
    }

    @GetMapping("/comment")
    public List<Comment> getAllComment() {
        List<Comment> comment = commentUseCase.getAllComment();
        return comment;
    }

    @GetMapping("/comment/{id}")
    public Comment listCommentByID(@PathVariable int id) {
        return commentUseCase.listCommentByID(id);
    }

    @GetMapping("/comment/user/{id}")
    public List<Comment> listCommentsByUserID(@PathVariable int id) {
        List<Comment> comment = commentUseCase.listCommentsByUserID(id);
        return comment;
    }

    @GetMapping("/comment/product/{id}")
    public List<Comment> listCommentsByProductID(@PathVariable int id) {
        List<Comment> comment = commentUseCase.listCommentsByProductID(id);
        return comment;
    }
    @GetMapping("/comment/feeling/{id}")
    public List<Comment> listCommentsByFeelingID(@PathVariable int id) {
        List<Comment> comment = commentUseCase.listCommentsByFeelingID(id);
        return comment;
    }
    @DeleteMapping("/comment/{id}")
    public String deleteComment(@PathVariable int id) {
        return commentUseCase.deleteComment(id);
    }
}
