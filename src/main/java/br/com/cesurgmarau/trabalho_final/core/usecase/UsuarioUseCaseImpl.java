package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioUseCaseImpl implements br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioUseCase {
    @Autowired

    private UsuarioRepository usuarioRepository;

    public UsuarioUseCaseImpl(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void adicionarUsuario(Usuario usuario) {
        this.usuarioRepository.adicionarUsuario(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return this.usuarioRepository.listarUsuarios();
    }

    @Override
    public void usuarioPorId(int id, Usuario usuario) {

    }

    @Override
    public void atualizarUsuario(int id, Usuario usuario) {

    }

    @Override
    public void deletarUsuario(int id) {

    }
}
