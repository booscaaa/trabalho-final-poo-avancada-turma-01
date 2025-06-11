package br.com.cesurgmarau.trabalho_final.core.domain.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class UsuarioUseCaseImpl implements UsuarioUseCase {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.salvar(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Usuario> listarTodos() {
        return List.of();
    }

    @Override
    public Usuario atualizarUsuario(Long id, Usuario usuario) {
        return null;
    }

    @Override
    public void deletarUsuario(Long id) {

    }
}
