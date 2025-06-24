package br.com.cesurgmarau.trabalho_final.core.domain.contract.Usuario;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.core.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioController {
    void cadastraUsuario(UsuarioDTO usuarioDTO);
    List<Usuario> listarUsuario();
    Usuario getId(Long id);
    void atualizaUsuario(UsuarioDTO usuarioDTO, Long id);
    void deletaUsuario(Long id);
}
