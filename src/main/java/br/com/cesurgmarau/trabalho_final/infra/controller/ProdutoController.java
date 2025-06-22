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
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());

        Produto salvo = produtoUseCase.salvar(produto);
        return new ProdutoResponse(salvo.getId(), salvo.getNome(), salvo.getDescricao());
    }

    @GetMapping("/{id}")
    public ProdutoResponse buscarPorId(@PathVariable Integer id) {
        return produtoUseCase.buscarPorId(id)
                .map(p -> new ProdutoResponse(p.getId(), p.getNome(), p.getDescricao()))
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado"));
    }

    @GetMapping
    public List<ProdutoResponse> listarTodos() {
        return produtoUseCase.listarTodos().stream()
                .map(p -> new ProdutoResponse(p.getId(), p.getNome(), p.getDescricao()))
                .toList();
    }

    @PutMapping("/{id}")
    public ProdutoResponse atualizar(@PathVariable Integer id, @RequestBody ProdutoRequest dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());

        produtoUseCase.atualizar(id, produto);

        Produto atualizado = produtoUseCase.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não encontrado após atualização"));

        return toResponse(atualizado);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Integer id) {
        produtoUseCase.remover(id);
    }
}

