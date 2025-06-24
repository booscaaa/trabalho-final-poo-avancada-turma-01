package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.DTO.RelatorioComentariosDTO;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.UseCase.ComentariosUseCase;
import br.com.cesurgmarau.trabalho_final.Core.domain.entity.Comentarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComentariosController {
    @Autowired
    ComentariosUseCase comentariosUseCase;

    @GetMapping ("/comentario")
    public ResponseEntity<?> fetch () throws Exception {
        try {
            List<Comentarios> comentarios = comentariosUseCase.fetch();
            return ResponseEntity.ok(comentarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar os comentarios! " + e.getMessage());
        }

    }

    @GetMapping ("/comentario/id/{id}")
    public ResponseEntity<?> fetchById (@PathVariable int id) throws Exception {

        try {
            Comentarios comentario = comentariosUseCase.fetchById(id);
            return ResponseEntity.ok(comentario);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar comentario! " + e.getMessage());
        }

    }

    @PostMapping("/comentario")
    public ResponseEntity createComentario (@RequestBody Comentarios comentario) throws Exception {

        try {

            comentariosUseCase.createComentario(comentario);
            return ResponseEntity.status(HttpStatus.CREATED).body("Comentario adicionado com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao adicionar o comentario! " + e.getMessage());
        }

    }

    @PutMapping("comentario/{id}")
    public ResponseEntity updateComentario (@RequestBody Comentarios comentario, @PathVariable int id) throws Exception{

        try {

            comentariosUseCase.updateComentario(comentario, id);
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

            comentariosUseCase.deleteComentario(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Comentario excluído com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao excluir comentario! " + e.getMessage());
        }

    }

    @GetMapping("/comentario/relatorio")
    public ResponseEntity<?> gerarRelatorio() {
        try {
            RelatorioComentariosDTO relatorio = comentariosUseCase.gerarRelatorio();
            return ResponseEntity.ok(relatorio);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao gerar relatório: " + e.getMessage());
        }
    }
    @GetMapping("/comentarios/sentimento/{sentimento}")
    public ResponseEntity<?> buscarPorSentimento(@PathVariable String sentimento) {
        try {
            List<Comentarios> comentarios = comentariosUseCase.buscarPorSentimento(sentimento.toLowerCase());
            return ResponseEntity.ok(comentarios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar comentários por sentimento: " + e.getMessage());
        }
    }




}
