package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoRequest;
import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoUseCaseImpl implements ProdutoUseCase {

    private final ProdutoRepository produtoRepository;

    public ProdutoUseCaseImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public ProdutoResponse salvar(ProdutoRequest dto) {
        Produto produto = new Produto();
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());

        Produto salvo = produtoRepository.salvar(produto);
        return new ProdutoResponse(salvo.getId(), salvo.getNome(), salvo.getDescricao());
    }

    @Override
    public Optional<ProdutoResponse> buscarPorId(Integer id) {
        return produtoRepository.buscarPorId(id)
                .map(produto -> new ProdutoResponse(produto.getId(), produto.getNome(), produto.getDescricao()));
    }

    @Override
    public List<ProdutoResponse> listarTodos() {
        return produtoRepository.listarTodos().stream()
                .map(produto -> new ProdutoResponse(produto.getId(), produto.getNome(), produto.getDescricao()))
                .collect(Collectors.toList());
    }

    @Override
    public ProdutoResponse atualizar(Integer id, ProdutoRequest dto) {
        Produto produto = new Produto();
        produto.setId(id);
        produto.setNome(dto.getNome());
        produto.setDescricao(dto.getDescricao());

        Produto atualizado = produtoRepository.atualizar(produto);
        return new ProdutoResponse(atualizado.getId(), atualizado.getNome(), atualizado.getDescricao());
    }

    @Override
    public void remover(Integer id) {
        produtoRepository.remover(id);
    }
}
