package br.com.cesurgmarau.trabalho_final.core.domain.contract.UseCase;

import java.util.List;

public interface UsuariosUseCase {
    List<br.com.cesurgmarau.trabalho_final.Core.domain.entity.Usuarios> fetch ();
    br.com.cesurgmarau.trabalho_final.Core.domain.entity.Usuarios fetchById (int id);
    void createUsuarios (br.com.cesurgmarau.trabalho_final.Core.domain.entity.Usuarios usuarios);
    void updateUsuarios (br.com.cesurgmarau.trabalho_final.Core.domain.entity.Usuarios usuarios, int id);
    void deleteUsuarios (int id);
}
