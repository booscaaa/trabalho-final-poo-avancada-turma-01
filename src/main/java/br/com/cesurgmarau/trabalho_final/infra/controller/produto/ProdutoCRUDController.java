package br.com.cesurgmarau.trabalho_final.infra.controller.produto;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.produto.CRUD.ProdutoCRUDUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoCRUDController {

    @Autowired
    ProdutoCRUDUseCase produtoCRUDUseCase;

    @GetMapping ("/produtos")
    public ResponseEntity<?> fetch () throws Exception {
        try {
            List<Produto> produtos = produtoCRUDUseCase.fetch();
            return ResponseEntity.ok(produtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar os produtos! " + e.getMessage());
        }

    }

    @GetMapping ("/produto/{id}")
    public ResponseEntity<?> fetchById (@PathVariable int id) throws Exception {

        try {
            Produto produto = produtoCRUDUseCase.fetchById(id);
            return ResponseEntity.ok(produto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao buscar produto! " + e.getMessage());
        }

    }

    @PostMapping ("/produto")
    public ResponseEntity createProduto (@RequestBody Produto produto) throws Exception {

        try {

            produtoCRUDUseCase.createProduto(produto);
            return ResponseEntity.status(HttpStatus.CREATED).body("Produto adicionado com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao adicionar o produto! " + e.getMessage());
        }

    }

    @PutMapping ("produto/{id}")
    public ResponseEntity updateProduto (@RequestBody Produto produto, @PathVariable int id) throws Exception{

        try {

            produtoCRUDUseCase.updateProduto(produto, id);
            return ResponseEntity.status(HttpStatus.OK)
                    .body("Produto atualizado com sucesso!");

        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao atualizar produto " + e.getMessage());

        }

    }

    @DeleteMapping ("produto/{id}")
    public ResponseEntity deleteProduto (@PathVariable int id) throws Exception {

        try {

            produtoCRUDUseCase.deleteProduto(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED)
                    .body("Produto excluído com sucesso!");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erro ao excluir produto! " + e.getMessage());
        }

    }

}
