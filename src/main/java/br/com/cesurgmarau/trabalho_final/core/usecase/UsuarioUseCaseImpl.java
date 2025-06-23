package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.core.domain.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioUseCaseImpl implements UsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public UsuarioUseCaseImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void insert(Usuario usuario) {
        usuarioRepository.insert(usuario);
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
    public List<Usuario> fetch() {
        return usuarioRepository.fetch();
    }

    @Override
    public Usuario get(int id) {
        return usuarioRepository.get(id);
    }
}
