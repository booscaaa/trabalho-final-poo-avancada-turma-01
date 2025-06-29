package br.com.cesurgmarau.trabalho_final.core.domain.contract.Usuario;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;

import java.util.List;

public interface UsuarioRepository {
    public void create(Usuario usuario);
    public void update(int id, Usuario usuario);
    public void delete(int id);
    public List<Usuario> fetch();
    public Usuario fetchById(int id);
}
