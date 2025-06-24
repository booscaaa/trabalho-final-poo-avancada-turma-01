package br.com.cesurgmarau.trabalho_final.core.domain.contract.Comentario;


import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioDTO;

import java.util.List;

public interface ComentarioController {
    void cadastrarComentario(ComentarioDTO comentarioDTO);
    List<Comentario> listarComentario();
    Comentario getId(Long id);
    void atualizarComentario(ComentarioDTO comentarioDTO, Long id);
    void deletaComentario(Long id);
}

