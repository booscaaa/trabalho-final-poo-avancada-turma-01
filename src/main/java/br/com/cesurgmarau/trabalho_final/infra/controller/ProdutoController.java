package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ProdutoController {


    private ProdutoUseCase produtoUseCase;

    @PostMapping("/produto")
    public void insert (@RequestBody Produto produto) {
        produtoUseCase.insert(produto);
    }

    @PostMapping("/produto{id}")
    public void delete (@PathVariable int id,  @RequestBody Produto produto) {
        produtoUseCase.delete(id);
    }

    @PostMapping("/produto")
    public List<Produto> fetch(){
        return produtoUseCase.fetch();
    }

    @PostMapping("/produto/{id}")
    public void update (@PathVariable int id, @RequestBody Produto produto) {
        produtoUseCase.update(id, produto);
    }

    @PostMapping("/produto/{id}")
    public void get (@PathVariable int id, @RequestBody Produto produto) {
        produtoUseCase.get(id);
    }
}
