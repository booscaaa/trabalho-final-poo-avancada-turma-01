package br.com.cesurgmarau.trabalho_final.core.domain.contract.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;

import java.util.List;

public interface ProdutoRepository {
    void createProduto(Produto produto);
    List<Produto> readProduto();
    Produto readProduto(Integer id);
    void updateProduto(Integer id, Produto produto);
    void deleteProduto(Integer id);
}
