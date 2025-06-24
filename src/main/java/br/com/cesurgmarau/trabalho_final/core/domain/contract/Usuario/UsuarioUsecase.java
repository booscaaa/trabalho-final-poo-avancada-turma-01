package br.com.cesurgmarau.trabalho_final.core.domain.contract.Usuario;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;

import java.util.List;

public interface UsuarioUsecase {
    void cadastraUsuario(Usuario usuario);
    List<Usuario> listarUsuario();
    Usuario getId(Long id);
    void atualizaUsuario(Usuario usuario, Long id);
    void deletaUsuario(Long id);
}
