package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoUseCaseImpl implements ProdutoUseCase {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void adicionarProduto(Produto produto) {
        produtoRepository.adicionarProduto(produto);
    }

    @Override
    public Produto listarProdutoPorId(int id) {
        return produtoRepository.listarProdutoPorId(id);
    }

    @Override
    public List<Produto> listarProdutos() {
        return produtoRepository.listarProdutos();
    }

    @Override
    public void deletarProduto(int id) {
        produtoRepository.deletarProduto(id);
    }

    @Override
    public void atualizarProduto(int id, Produto produto) {
        produtoRepository.atualizarProduto(id, produto);
    }
}
