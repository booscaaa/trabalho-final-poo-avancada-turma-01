package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoRequest;
import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoResponse;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoUsecase;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoUsecase produtoUseCase;

    public ProdutoController(ProdutoUsecase produtoUseCase) {
        this.produtoUseCase = produtoUseCase;
    }

    private ProdutoResponse toResponse(Produto produto) {
        return new ProdutoResponse(produto.getId(), produto.getNome(), produto.getDescricao());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponse salvar(@RequestBody ProdutoRequest dto) {
        Produto produto = produtoUseCase.salvar(dto);
        return toResponse(produto);
    }

    @GetMapping("/{id}")
    public ProdutoResponse buscarPorId(@PathVariable Integer id) {
        Produto produto = produtoUseCase.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
        return toResponse(produto);
    }

    @GetMapping
    public List<ProdutoResponse> listarTodos() {
        return produtoUseCase.listarTodos().stream()
                .map(this::toResponse)
                .toList();
    }

    @PutMapping("/{id}")
    public ProdutoResponse atualizar(@PathVariable Integer id, @RequestBody ProdutoRequest dto) {
        Produto produto = produtoUseCase.atualizar(id, dto);
        return toResponse(produto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id) {
        produtoUseCase.remover(id);
    }
}

