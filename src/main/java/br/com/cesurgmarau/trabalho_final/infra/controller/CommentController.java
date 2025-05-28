package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.CommentUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CommentController {

    @Autowired
    private CommentUseCase commentUseCase;


    @GetMapping("/comment")
    public List<Comment> listAllComments() {
        return commentUseCase.listAllComments();
    }

    @GetMapping("/comment/{id}")
    public Comment listByID (@PathVariable int id) {
        return commentUseCase.listByID(id);
    }

    @PostMapping("/comment")
    public void createComment (@RequestBody Comment comment) {
        commentUseCase.createComment(comment);
    }

    @DeleteMapping("/comment/{id}")
    public String deleteComment (@PathVariable int id) {
        return commentUseCase.deleteComment(id);
    }

    @PutMapping("/comment/{id}")
    public String updateComment (@PathVariable int id, @RequestBody Comment comment) {
        return commentUseCase.updateComment(id, comment);
    }
}
