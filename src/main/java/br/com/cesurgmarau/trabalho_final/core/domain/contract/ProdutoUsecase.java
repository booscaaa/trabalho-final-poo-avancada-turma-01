package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoRequest;

import java.util.List;
import java.util.Optional;

public interface ProdutoUsecase {
    Produto salvar(ProdutoRequest dto);
    Optional<Produto> buscarPorId(Integer id);
    List<Produto> listarTodos();
    Produto atualizar(Integer id, ProdutoRequest dto);
    void remover(Integer id);
}
