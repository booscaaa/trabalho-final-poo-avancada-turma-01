package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Produto.ProdutoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Produto.ProdutoUsecase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoUsecaseIMPL implements ProdutoUsecase {
    @Autowired
    ProdutoRepository produtoRepository;
    @Override
    public void cadastrarProduto(Produto produto) {
        produtoRepository.cadastrarProduto(produto);
    }

    @Override
    public List<Produto> listarProdutos() {
       return produtoRepository.listarProdutos();
    }

    @Override
    public Produto getId(Long id) {
        return produtoRepository.getId(id);
    }

    @Override
    public void atualizarProduto(Produto produto, Long id) {
        produtoRepository.atualizarProduto(produto, id);
    }

    @Override
    public void deletaProduto(Long id) {
        produtoRepository.deletaProduto(id);
    }
}
