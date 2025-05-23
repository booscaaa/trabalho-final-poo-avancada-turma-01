package br.com.cesurgmarau.trabalho_final.core.domain.contract.Comentario;

import br.com.cesurgmarau.trabalho_final.core.domain.dto.ComentarioDTO;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;

import java.util.List;

public interface ComentarioUseCase {
    public void create(Comentario comentario);
    public void update(int id, Comentario comentario);
    public void delete(int id);
    public ComentarioDTO findById(int id);
    public List<Comentario> fetch();
}
