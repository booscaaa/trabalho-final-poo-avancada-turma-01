package br.com.cesurgmarau.trabalho_final.service.interfaces;

import br.com.cesurgmarau.trabalho_final.dto.ProdutoDTO;

import java.util.List;

public interface ProdutoService {
    ProdutoDTO salvar(ProdutoDTO dto);
    ProdutoDTO buscarPorId(Long id);
    List<ProdutoDTO> listarTodos();
    ProdutoDTO atualizar(Long id, ProdutoDTO dto);
    void remover(Long id);
}
