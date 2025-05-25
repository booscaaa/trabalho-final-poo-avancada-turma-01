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

    }

    @Override
    public Produto listarProdutoPorId(int id) {
        return null;
    }

    @Override
    public List<Produto> listarProdutos() {
        return List.of();
    }

    @Override
    public void deletarProduto(int id) {

    }

    @Override
    public void atualizarProduto(int id, Produto produto) {

    }
}
