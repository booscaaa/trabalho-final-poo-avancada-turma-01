package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.core.dto.UsuarioRequest;

import java.util.List;
import java.util.Optional;

public interface UsuarioUsecase {
    Usuario criar(UsuarioRequest request);
    Optional<Usuario> buscarPorId(Integer id);
    List<Usuario> listarTodos();
    Usuario atualizar(Integer id, UsuarioRequest request);
    void remover(Integer id);
}
