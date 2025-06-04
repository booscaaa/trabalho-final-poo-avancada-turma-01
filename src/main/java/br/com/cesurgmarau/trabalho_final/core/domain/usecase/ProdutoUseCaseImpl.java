package br.com.cesurgmarau.trabalho_final.core.domain.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;

import java.util.List;
import java.util.Optional;

public class ProdutoUseCaseImpl implements ProdutoUseCase {

    @Override
    public Produto criarProduto(Produto produto) {
        return null;
    }

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Produto> listarTodos() {
        return List.of();
    }

    @Override
    public Produto atualizarProduto(Long id, Produto produto) {
        return null;
    }

    @Override
    public void deletarProduto(Long id) {

    }
}
