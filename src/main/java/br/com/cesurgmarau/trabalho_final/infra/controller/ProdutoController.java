package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoUseCase produtoUseCase;

    @PostMapping("/produto")
    public void criarProduto(@RequestBody Produto produto){
        produtoUseCase.adicionarProduto(produto);
    }

    @GetMapping("/produto/{id}")
    public Produto listarProdutoPorId (@PathVariable int id){
        return produtoUseCase.listarProdutoPorId(id);
    }

    @GetMapping("/produto")
    public List<Produto> listarProdutos(){
        return produtoUseCase.listarProdutos();
    }

    @DeleteMapping("/produto/{id}")
    public void deletarProduto(@PathVariable int id){
        produtoUseCase.deletarProduto(id);
    }

    @PutMapping("/produto/{id}")
    public void atualizarProduto(@PathVariable int id, @RequestBody Produto produto){
        produtoUseCase.atualizarProduto(id, produto);
    }
}
