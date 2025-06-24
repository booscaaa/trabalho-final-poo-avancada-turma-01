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
    public List<Produto> listar() {
        return produtoRepository.listar();
    }

    @Override
    public Produto listarPorId(int id) {
        return produtoRepository.listarPorId(id);
    }

    @Override
    public void adicionarProduto(Produto produto) {
        produtoRepository.adicionarProduto(produto);
    }

    @Override
    public String deletarProduto(int id) {
        return produtoRepository.deletarProduto(id);
    }

    @Override
    public String atualizarProduto(int id, Produto produto) {
        return produtoRepository.atualizarProduto(id, produto);
    }
}
