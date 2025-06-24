package br.com.cesurgmarau.trabalho_final.core.domain.contract.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;

import java.util.List;

public interface UsuarioRepository {
    void createUsuario(Usuario usuario);
    List<Usuario> readUsuario();
    Usuario readUsuario(Integer id);
    void updateUsuario(Integer id, Usuario usuario);
    void deleteUsuario(Integer id);
}
