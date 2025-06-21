package br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioContracts;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;

import java.util.List;

public interface UsuarioRepository {
    void adicionarUsuario(Usuario usuario);
    List<Usuario> listarUsuarios();
    Usuario usuarioPorId(int id);
    void atualizarUsuario(int id, Usuario usuario);
    void deletarUsuario(int id);
}
