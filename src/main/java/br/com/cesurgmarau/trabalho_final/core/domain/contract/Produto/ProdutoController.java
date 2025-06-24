package br.com.cesurgmarau.trabalho_final.core.domain.contract.Produto;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoDTO;

import java.util.List;

public interface ProdutoController {
    void cadastrarProduto(ProdutoDTO produtoDTO);
    List<Produto> listarProdutos();
    Produto getId(Long id);
    void atualizarProduto(ProdutoDTO produtoDTO, Long id);
    void deletaProduto(Long id);
}
