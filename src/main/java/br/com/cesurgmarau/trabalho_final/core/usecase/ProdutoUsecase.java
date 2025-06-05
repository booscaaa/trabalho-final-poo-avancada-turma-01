package br.com.cesurgmarau.trabalho_final.core.usecase;


import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoRequest;
import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoResponse;

import java.util.List;
import java.util.Optional;

public interface ProdutoUsecase {
    ProdutoResponse salvar(ProdutoRequest dto);
    Optional<ProdutoResponse> buscarPorId(Integer id);
    List<ProdutoResponse> listarTodos();
    ProdutoResponse atualizar(Integer id, ProdutoRequest dto);
    void remover(Integer id);
}
