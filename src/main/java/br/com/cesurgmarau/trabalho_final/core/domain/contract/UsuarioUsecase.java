package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.dto.UsuarioRequest;
import br.com.cesurgmarau.trabalho_final.core.dto.UsuarioResponse;

import java.util.List;

public interface UsuarioUsecase {
    UsuarioResponse criar(UsuarioRequest request);
    UsuarioResponse buscarPorId(Integer id);
    List<UsuarioResponse> listarTodos();
    UsuarioResponse atualizar(Integer id, UsuarioRequest request);
    void remover(Integer id);
}
