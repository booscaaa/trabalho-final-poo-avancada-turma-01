package br.com.cesurgmarau.trabalho_final.core.domain.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Usuario.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Usuario.UsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioUseCaseImpl implements UsuarioUseCase {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void create(Usuario usuario) {
        usuarioRepository.create(usuario);
    }

    @Override
    public void update(int id, Usuario usuario) {
        usuarioRepository.update(id, usuario);
    }

    @Override
    public void delete(int id) {
        usuarioRepository.delete(id);
    }

    @Override
    public Usuario fetchById(int id) {
        return usuarioRepository.fetchById(id);
    }

    @Override
    public List<Usuario> fetch() {
        return usuarioRepository.fetch();
    }
}
