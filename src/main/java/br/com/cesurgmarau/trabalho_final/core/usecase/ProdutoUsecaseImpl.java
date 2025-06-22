package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoUsecase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoUsecaseImpl implements ProdutoUsecase {

    private final ProdutoRepository produtoRepository;

    public ProdutoUsecaseImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Produto salvar(ProdutoRequest dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());

        return produtoRepository.salvar(produto);
    }

    @Override
    public Optional<Produto> buscarPorId(Integer id) {
        return produtoRepository.buscarPorId(id);
    }

    @Override
    public List<Produto> listarTodos() {
        return produtoRepository.listarTodos();
    }

    @Override
    public Produto atualizar(Integer id, ProdutoRequest dto) {
        Produto produto = new Produto();
        produto.setId(id);
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());

        return produtoRepository.atualizar(produto);
    }

    @Override
    public void remover(Integer id) {
        produtoRepository.remover(id);
    }
}

