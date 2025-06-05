package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoRequest;
import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoResponse;
import br.com.cesurgmarau.trabalho_final.core.usecase.ProdutoUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoUsecase produtoUseCase;

    public ProdutoController(ProdutoUsecase produtoUseCase) {
        this.produtoUseCase = produtoUseCase;
    }

    @PostMapping
    public ResponseEntity<ProdutoResponse> salvar(@RequestBody ProdutoRequest dto) {
        ProdutoResponse response = produtoUseCase.salvar(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoResponse> buscarPorId(@PathVariable Integer id) {
        return produtoUseCase.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<ProdutoResponse>> listarTodos() {
        List<ProdutoResponse> produtos = produtoUseCase.listarTodos();
        return ResponseEntity.ok(produtos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoResponse> atualizar(@PathVariable Integer id, @RequestBody ProdutoRequest dto) {
        ProdutoResponse response = produtoUseCase.atualizar(id, dto);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Integer id) {
        produtoUseCase.remover(id);
        return ResponseEntity.noContent().build();
    }
}
