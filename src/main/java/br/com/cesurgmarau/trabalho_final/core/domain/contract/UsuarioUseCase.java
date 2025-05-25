package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;

import java.util.List;

public interface UsuarioUseCase {
    public void adicionarUsuario (Usuario usuario);
    public Usuario listarUsuarioPorId(int id);
    public List<Usuario> listarUsuarios();
    public void deletarUsuario (int id);
    public void atualizarUsuario(int id, Usuario usuario);
}
