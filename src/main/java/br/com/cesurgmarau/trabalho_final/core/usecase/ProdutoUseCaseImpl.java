package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoContracts.ProdutoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoContracts.ProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoUseCaseImpl implements ProdutoUseCase {
    @Autowired

    private ProdutoRepository produtoRepository;

    public ProdutoUseCaseImpl(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @Override
    public void adicionarProduto(Produto produto) {
        this.produtoRepository.adicionarProduto(produto);
    }

    @Override
    public List<Produto> listarProdutos() {
        return this.produtoRepository.listarProdutos();
    }

    @Override
    public Produto produtoPorID(int id) {
        return this.produtoRepository.produtoPorID(id);
    }

    @Override
    public void atualizarProduto(int id, Produto produto) {
        Produto existente = this.produtoRepository.produtoPorID(id);
        if (existente == null) {
            throw new IllegalArgumentException("Usuário com o ID fornecido não existe.");
        }

        this.produtoRepository.atualizarProduto(id, produto);
    }

    @Override
    public void deletarProduto(int id) {
        Produto existente = this.produtoRepository.produtoPorID(id);
        if (existente == null) {
            throw new IllegalArgumentException("Usuário com o ID fornecido não existe.");
        }
        this.produtoRepository.deletarProduto(id);
    }
}
