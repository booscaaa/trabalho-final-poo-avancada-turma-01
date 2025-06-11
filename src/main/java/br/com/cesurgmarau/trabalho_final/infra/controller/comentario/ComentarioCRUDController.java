package br.com.cesurgmarau.trabalho_final.infra.controller.comentario;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.CRUD.ComentarioCRUDUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.produto.CRUD.ProdutoCRUDUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComentarioCRUDController {

    @Autowired
    ComentarioCRUDUseCase comentarioCRUDUseCase;

    @GetMapping("/comentarios")
    public ResponseEntity<?> fetch () throws Exception {
        try {
            List<Comentario> comentarios = comentarioCRUDUseCase.fetch();
            return ResponseEntity.ok(comentarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar os comentarios! " + e.getMessage());
        }

    }

    @GetMapping ("/comentario/{id}")
    public ResponseEntity<?> fetchById (@PathVariable int id) throws Exception {

        try {
            Comentario comentario = comentarioCRUDUseCase.fetchById(id);
            return ResponseEntity.ok(comentario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar comentario! " + e.getMessage());
        }

    }

    @PostMapping("/produto/{produtoID}/comentario")
    public ResponseEntity createComentario (@RequestBody Comentario comentario, @PathVariable int produtoID) throws Exception {

        try {
            comentarioCRUDUseCase.createComentario(comentario, produtoID);
            return ResponseEntity.status(HttpStatus.CREATED).body("Comentario adicionado com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao adicionar o comentario! " + e.getMessage());
        }

    }

    @PutMapping("comentario/{id}")
    public ResponseEntity updateComentario (@RequestBody Comentario comentario, @PathVariable int id) throws Exception{

        try {

            comentarioCRUDUseCase.updateComentario(comentario, id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Comentario atualizado com sucesso!");

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar comentario " + e.getMessage());

        }

    }

    @DeleteMapping ("comentario/{id}")
    public ResponseEntity deleteComentario (@PathVariable int id) throws Exception {

        try {

            comentarioCRUDUseCase.deleteComentario(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Comentario excluído com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao excluir comentario! " + e.getMessage());
        }

    }



}
