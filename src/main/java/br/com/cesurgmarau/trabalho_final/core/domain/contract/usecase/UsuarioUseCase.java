package br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;

import java.util.List;

public interface UsuarioUseCase {
    void createUsuario(Usuario usuario);
    List<Usuario> readUsuario();
    Usuario readUsuario(Integer id);
    void updateUsuario(Integer id, Usuario usuario);
    void deleteUsuario(Integer id);
}
