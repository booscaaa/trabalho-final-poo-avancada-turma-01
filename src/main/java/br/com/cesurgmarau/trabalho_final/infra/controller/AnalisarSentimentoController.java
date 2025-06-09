package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UseCase.AnalisarSentimentoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnalisarSentimentoController {
    @Autowired
    AnalisarSentimentoUseCase analisarSentimentoUseCase;

    @GetMapping("/analise")
    public ResponseEntity<?> fetch () throws Exception {
        try {
            List<br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento> analisarSentimento = analisarSentimentoUseCase.fetch();
            return ResponseEntity.ok(analisarSentimentoUseCase);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar os Analise! " + e.getMessage());
        }

    }

    @GetMapping ("/analise/{id}")
    public ResponseEntity<?> fetchById (@PathVariable int id) throws Exception {

        try {
            br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento analisarSentimento = analisarSentimentoUseCase.fetchById(id);
            return ResponseEntity.ok(analisarSentimento);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar a analise! " + e.getMessage());
        }

    }

    @PostMapping("/analise")
    public ResponseEntity createAnaliseDeSentimento (@RequestBody br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento analisarSentimento) throws Exception {

        try {

            analisarSentimentoUseCase.createAnaliseDeSentimento(analisarSentimento);
            return ResponseEntity.status(HttpStatus.CREATED).body("Analise adicionado com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao adicionar uma analise! " + e.getMessage());
        }

    }

    @PutMapping("analise/{id}")
    public ResponseEntity updateAnaliseDeSentimento (@RequestBody br.com.cesurgmarau.trabalho_final.Core.domain.entity.AnalisarSentimento analisarSentimento, @PathVariable int id) throws Exception{

        try {

            analisarSentimentoUseCase.updateAnaliseDeSentimento(analisarSentimento, id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Analise atualizada com sucesso!");

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar a analise " + e.getMessage());

        }

    }

    @DeleteMapping ("analise/{id}")
    public ResponseEntity deleteAnaliseDeSentimento (@PathVariable int id) throws Exception {

        try {

            analisarSentimentoUseCase.deleteAnaliseDeSentimento(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Analise excluída com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao excluir a analise! " + e.getMessage());
        }

    }
}
