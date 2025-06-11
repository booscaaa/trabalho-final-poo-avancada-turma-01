package br.com.cesurgmarau.trabalho_final.core.domain.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoUseCaseImpl implements ProdutoUseCase {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Override
    public Produto criarProduto(Produto produto) {
        return produtoRepository.salvar(produto);
    }

    @Override
    public Optional<Produto> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Produto> listarTodos() {
        return List.of();
    }

    @Override
    public Produto atualizarProduto(Long id, Produto produto) {
        return null;
    }

    @Override
    public void deletarProduto(Long id) {

    }
}
