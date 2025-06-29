package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Produto.ProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {
    @Autowired
    private ProdutoUseCase produtoUseCase;

    @PostMapping("/produto")
    public void create(@RequestBody Produto produto){
        produtoUseCase.create(produto);
    }

    @PutMapping("/produto/{id}")
    public void update(@RequestBody Produto produto, @PathVariable int id){
        produtoUseCase.update(id, produto);
    }

    @DeleteMapping("/produto/{id}")
    public void delete(@PathVariable int id){
        produtoUseCase.delete(id);
    }

    @GetMapping("/produto/{id}")
    public Produto findById(@PathVariable int id){
        return produtoUseCase.findById(id);
    }

    @GetMapping("/produto")
    public List<Produto> fetch(){
        return produtoUseCase.fetch();
    }

}
