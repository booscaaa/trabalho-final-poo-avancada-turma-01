package br.com.cesurgmarau.trabalho_final.core.domain.contract.Produto;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;

import java.util.List;

public interface ProdutoRepository {
    void cadastrarProduto(Produto produto);
    List<Produto> listarProdutos();
    Produto getId(Long id);
    void atualizarProduto(Produto produto, Long id);
    void deletaProduto(Long id);
}
