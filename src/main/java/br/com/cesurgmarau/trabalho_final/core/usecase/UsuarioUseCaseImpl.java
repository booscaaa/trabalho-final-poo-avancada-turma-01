package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.repository.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase.UsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioUseCaseImpl implements UsuarioUseCase {

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public void createUsuario(Usuario usuario) {
        usuarioRepository.createUsuario(usuario);
    }

    @Override
    public List<Usuario> readUsuario() {
        return usuarioRepository.readUsuario();
    }

    @Override
    public Usuario readUsuario(Integer id) {
        return usuarioRepository.readUsuario(id);
    }

    @Override
    public void updateUsuario(Integer id, Usuario usuario) {
        usuarioRepository.updateUsuario(id, usuario);
    }

    @Override
    public void deleteUsuario(Integer id) {
        usuarioRepository.deleteUsuario(id);
    }
}
