package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.UsuarioUsecase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioUsecaseImpl implements UsuarioUsecase {

    private final UsuarioRepository usuarioRepository;

    public UsuarioUsecaseImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario criar(Usuario usuario) {
        return usuarioRepository.salvar(usuario);
    }

    @Override
    public Optional<Usuario> buscarPorId(Integer id) {
        return usuarioRepository.buscarPorId(id);
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.listarTodos();
    }

    @Override
    public void atualizar(Integer id, Usuario usuario) {
        usuarioRepository.atualizar(id, usuario);
    }

    @Override
    public void remover(Integer id) {
        usuarioRepository.remover(id);
    }
}
