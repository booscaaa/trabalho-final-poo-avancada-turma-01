package br.com.cesurgmarau.trabalho_final.core.domain.contract.usuario.CRUD;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;

import java.util.List;

public interface UsuarioCRUDUseCase {

    List<Usuario> fetch ();
    Usuario fetchById (int id);
    void createUsuario (Usuario usuario);
    void updateUsuario (Usuario usuario, int id);
    void deleteUsuario (int id);


}
