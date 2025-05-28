package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioUseCase {

    Usuario criarUsuario(Usuario usuario);

    Optional<Usuario> buscarPorId(Long id);

    List<Usuario> listarTodos();

    Usuario atualizarUsuario(Long id, Usuario usuario);

    void deletarUsuario(Long id);
}

