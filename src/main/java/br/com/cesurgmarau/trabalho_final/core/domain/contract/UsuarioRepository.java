package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Usuario salvar(Usuario usuario);
    Optional<Usuario> buscarPorId(Integer id);
    List<Usuario> listarTodos();
    Usuario atualizar(Usuario usuario);
    void remover(Integer id);
}
