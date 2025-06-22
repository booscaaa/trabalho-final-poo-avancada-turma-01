package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioUseCaseImpl implements UsuarioUseCase {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void adicionarUsuario(Usuario usuario) {
        usuarioRepository.adicionarUsuario(usuario);
    }

    @Override
    public Usuario listarUsuarioPorId(int id) {
        return usuarioRepository.listarUsuarioPorId(id);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.listarUsuarios();
    }

    @Override
    public void deletarUsuario(int id) {
        usuarioRepository.deletarUsuario(id);
    }

    @Override
    public void atualizarUsuario(int id, Usuario usuario) {
        usuarioRepository.atualizarUsuario(id, usuario);
    }
}
