package br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;

import java.util.List;

public interface ComentarioRepository {
    public void insert (Comentario comentario);
    public void update (int id, Comentario comentario);
    public void delete (int id);
    public List<Comentario> fetch();
    public Comentario get (int id);
}

