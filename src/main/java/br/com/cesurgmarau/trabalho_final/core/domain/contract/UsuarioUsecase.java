package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioUsecase {
    Usuario criar(Usuario usuario);
    Optional<Usuario> buscarPorId(Integer id);
    List<Usuario> listarTodos();
    void atualizar(Integer id, Usuario usuario);
    void remover(Integer id);
}
