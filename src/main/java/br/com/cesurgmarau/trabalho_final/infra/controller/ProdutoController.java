package br.com.cesurgmarau.trabalho_final.infra.controller;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping
public class ProdutoController {

    @Autowired
    private ProdutoUseCase produtoUseCase;

    @GetMapping("/produto")
    public List<Produto> listar() {
        return produtoUseCase.listar();
    }

    @GetMapping("/produto/{id}")

    public Produto listarPorId(@PathVariable int id) {
        return produtoUseCase.listarPorId(id);
    }

    @PostMapping("/produto")

    public void adicionarProduto(@RequestBody Produto produto) {
        produtoUseCase.adicionarProduto(produto);
    }

    @DeleteMapping("/produto/{id}")

    public String deletarProduto(@PathVariable int id) {
        return produtoUseCase.deletarProduto(id);
    }

    @PutMapping("/produto/{id}")

    public String atualizarProduto(@PathVariable int id, @RequestBody Produto produto) {
        return produtoUseCase.atualizarProduto(id, produto);
    }

}
