package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.repository.ProdutoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase.ProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoUseCaseImpl implements ProdutoUseCase {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public void createProduto(Produto produto) {
        produtoRepository.createProduto(produto);
    }

    @Override
    public List<Produto> readProduto() {
        return produtoRepository.readProduto();
    }

    @Override
    public Produto readProduto(Integer id) {
        return produtoRepository.readProduto(id);
    }

    @Override
    public void updateProduto(Integer id, Produto produto) {
        produtoRepository.updateProduto(id, produto);
    }

    @Override
    public void deleteProduto(Integer id) {
        produtoRepository.deleteProduto(id);
    }
}
