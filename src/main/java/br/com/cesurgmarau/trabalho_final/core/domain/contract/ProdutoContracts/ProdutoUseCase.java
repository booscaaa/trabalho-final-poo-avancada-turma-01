package br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoContracts;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;

import java.util.List;

public interface ProdutoUseCase {
    void adicionarProduto(Produto produto);
    List<Produto> listarProdutos();
    Produto produtoPorID(int id);
    void atualizarProduto(int id, Produto produto);
    void deletarProduto(int id);
}
