package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;

import java.util.List;

public interface UsuarioUseCase {
    void adicionarUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
    void usuarioPorId(int id, Usuario usuario);
    void atualizarUsuario(int id, Usuario usuario);
    void deletarUsuario(int id);
}
