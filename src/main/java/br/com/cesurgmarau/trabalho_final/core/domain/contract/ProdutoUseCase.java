package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoUseCase {

    Produto criarProduto(Produto produto);

    Optional<Produto> buscarPorId(Long id);

    List<Produto> listarTodos();

    Produto atualizarProduto(Long id, Produto produto);

    void deletarProduto(Long id);
}

