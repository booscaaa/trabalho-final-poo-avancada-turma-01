package br.com.cesurgmarau.trabalho_final.service.interfaces;

import br.com.cesurgmarau.trabalho_final.dto.ComentarioDTO;
import br.com.cesurgmarau.trabalho_final.dto.ComentarioRequestDTO;

import java.util.List;

public interface ComentarioService {
    ComentarioDTO salvar(ComentarioRequestDTO dto);
    ComentarioDTO buscarPorId(Long id);
    List<ComentarioDTO> listarTodos();
    List<ComentarioDTO> buscarPorProduto(Long produtoId);
    List<ComentarioDTO> buscarPorUsuario(Long usuarioId);
    List<ComentarioDTO> buscarPorSentimento(String sentimento);
}
