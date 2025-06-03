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
    public List<Usuario> listar(){
        return usuarioRepository.listar();
    }
    @Override
    public Usuario listarPorId(int id){
        return usuarioRepository.listarPorId(id);
    }
    @Override
    public void adicionarUsuario(Usuario usuario){
         usuarioRepository.adicionarUsuario(usuario);
    }
    @Override
    public String deletarUsuario(int id){
        return usuarioRepository.deletarUsuario(id);
    }
    @Override
    public String atualizarUsuario(int id, Usuario usuario){
        return usuarioRepository.atualizarUsuario(id, usuario);
    }
}
