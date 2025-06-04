package br.com.cesurgmarau.trabalho_final.core.domain.contract.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;

import java.util.List;

public interface UsuarioRepository {
    void createUsuario(Usuario usuario);
    List<Usuario> readUsuario();
    Usuario readUsuario(int id);
    void updateUsuario(int id, Usuario usuario);
    void deleteUsuario(int id);
}
