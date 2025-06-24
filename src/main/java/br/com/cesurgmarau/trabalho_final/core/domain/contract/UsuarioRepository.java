package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import java.util.List;



public interface UsuarioRepository {

    public List<Usuario>listar();
    public Usuario listarPorId(int id);
    public void adicionarUsuario(Usuario usuario);
    public String deletarUsuario(int id);
    public String atualizarUsuario(int id, Usuario usuario);
}

