package br.com.cesurgmarau.trabalho_final.core.usecase.usuario;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.usuario.CRUD.UsuarioCRUDRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usuario.CRUD.UsuarioCRUDUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioCRUDServiceImpl implements UsuarioCRUDUseCase {

    @Autowired
    UsuarioCRUDRepository usuarioCRUDRepository;

    @Override
    public List<Usuario> fetch() {
        return usuarioCRUDRepository.fetch();
    }

    @Override
    public Usuario fetchById(int id) {
        return usuarioCRUDRepository.fetchById(id);
    }

    @Override
    public void createUsuario(Usuario usuario) {
        usuarioCRUDRepository.createUsuario(usuario);
    }

    @Override
    public void updateUsuario(Usuario usuario, int id) {
        usuarioCRUDRepository.updateUsuario(usuario, id);
    }

    @Override
    public void deleteUsuario(int id) {
        usuarioCRUDRepository.deleteUsuario(id);
    }
}
