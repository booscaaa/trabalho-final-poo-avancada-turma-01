package br.com.cesurgmarau.trabalho_final.core.domain.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Produto.ProdutoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Produto.ProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoUseCaseImpl implements ProdutoUseCase {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public void create(Produto produto) {
        produtoRepository.create(produto);
    }

    @Override
    public void update(int id, Produto produto) {
        produtoRepository.update(id, produto);
    }

    @Override
    public void delete(int id) {
        produtoRepository.delete(id);
    }

    @Override
    public Produto findById(int id) {
        return produtoRepository.findById(id);
    }

    @Override
    public List<Produto> fetch() {
        return produtoRepository.fetch();
    }
}
