package br.com.cesurgmarau.trabalho_final.core.domain.contract.Repository;

import br.com.cesurgmarau.trabalho_final.Core.domain.entity.Usuarios;
import java.util.List;

public interface UsuariosRepository {
    List<Usuarios> fetch ();
    Usuarios fetchById (int id);
    void createUsuarios (Usuarios usuarios);
    void updateUsuarios (Usuarios usuarios, int id);
    void deleteUsuarios (int id);

}
