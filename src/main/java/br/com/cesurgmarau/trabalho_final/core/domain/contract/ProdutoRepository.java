package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {
    Produto salvar(Produto produto);
    Optional<Produto> buscarPorId(Integer id);
    List<Produto> listarTodos();
    Produto atualizar(Produto produto);
    void remover(Integer id);
}
