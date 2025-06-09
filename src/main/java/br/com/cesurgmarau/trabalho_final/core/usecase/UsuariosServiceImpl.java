package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UseCase.UsuariosUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImpl implements UsuariosUseCase{
    @Autowired
    UsuariosServiceImpl usuariosService;

    @Override
    public List<br.com.cesurgmarau.trabalho_final.Core.domain.entity.Usuarios> fetch() {
        return usuariosService.fetch();
    }

    @Override
    public br.com.cesurgmarau.trabalho_final.Core.domain.entity.Usuarios fetchById(int id) {
        return usuariosService.fetchById(id);
    }

    @Override
    public void createUsuarios(br.com.cesurgmarau.trabalho_final.Core.domain.entity.Usuarios usuarios) {
        usuariosService.createUsuarios(usuarios);
    }

    @Override
    public void updateUsuarios(br.com.cesurgmarau.trabalho_final.Core.domain.entity.Usuarios usuarios, int id) {
        usuariosService.updateUsuarios(usuarios, id);
    }

    @Override
    public void deleteUsuarios(int id) {
        usuariosService.deleteUsuarios(id);
    }

}
