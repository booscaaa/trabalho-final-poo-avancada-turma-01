package br.com.cesurgmarau.trabalho_final.service.interfaces;

import br.com.cesurgmarau.trabalho_final.dto.UsuarioDTO;
import br.com.cesurgmarau.trabalho_final.dto.UsuarioRequestDTO;

import java.util.List;

public interface UsuarioService {
    UsuarioDTO salvar(UsuarioRequestDTO dto);
    UsuarioDTO buscarPorId(Long id);
    List<UsuarioDTO> listarTodos();
    UsuarioDTO atualizar(Long id, UsuarioRequestDTO dto);
    void remover(Long id);
    void deletar(Long id);
}