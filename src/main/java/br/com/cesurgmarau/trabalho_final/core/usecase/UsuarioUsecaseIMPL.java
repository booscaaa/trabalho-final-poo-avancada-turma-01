package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Usuario.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Usuario.UsuarioUsecase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioUsecaseIMPL implements UsuarioUsecase {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Override
    public void cadastraUsuario(Usuario usuario) {
        usuarioRepository.cadastraUsuario(usuario);
    }

    @Override
    public List<Usuario> listarUsuario() {
        return usuarioRepository.listarUsuario();
    }

    @Override
    public Usuario getId(Long id) {
        return usuarioRepository.getId(id);
    }

    @Override
    public void atualizaUsuario(Usuario usuario, Long id) {
        usuarioRepository.atualizaUsuario(usuario, id);
    }

    @Override
    public void deletaUsuario(Long id) {
        usuarioRepository.deletaUsuario(id);
    }
}
