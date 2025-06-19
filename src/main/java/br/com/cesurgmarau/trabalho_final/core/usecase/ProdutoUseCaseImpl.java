package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoUseCaseImpl implements ProdutoUseCase {

    private ProdutoRepository produtoRepository;

    @Override
    public void insert(Produto produto) {
        produtoRepository.insert(produto);
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
    public List<Produto> fetch() {
        return produtoRepository.fetch();
    }

    @Override
    public Produto get(int id) {
        return produtoRepository.get(id);
    }
}
