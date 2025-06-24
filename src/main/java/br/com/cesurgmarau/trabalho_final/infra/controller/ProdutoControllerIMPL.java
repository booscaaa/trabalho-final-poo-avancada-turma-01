package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Produto.ProdutoController;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Produto.ProdutoUsecase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoControllerIMPL implements ProdutoController {

    @Autowired
    ProdutoUsecase produtoUsecase;

    @Override @PostMapping("/produto")
    public void cadastrarProduto(@RequestBody ProdutoDTO produtoDTO) {
        Produto produto = new Produto(null, produtoDTO.getNome(), produtoDTO.getValor(), produtoDTO.getDescricao());

        produtoUsecase.cadastrarProduto(produto);
    }

    @Override @GetMapping("/produto")
    public List<Produto> listarProdutos() {
        return produtoUsecase.listarProdutos();
    }

    @Override @GetMapping("/produto/{id}")
    public Produto getId(@PathVariable Long id) {
        return produtoUsecase.getId(id);
    }

    @Override @PutMapping("/produto/{id}")
    public void atualizarProduto(@RequestBody ProdutoDTO produtoDTO,@PathVariable Long id) {
        Produto produto = new Produto(null, produtoDTO.getNome(), produtoDTO.getValor(), produtoDTO.getDescricao());
        produtoUsecase.atualizarProduto(produto, id);
    }

    @Override @DeleteMapping("/produto/{id}")
    public void deletaProduto(@PathVariable Long id) {
        produtoUsecase.deletaProduto(id);
    }
}
