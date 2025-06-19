package br.com.cesurgmarau.trabalho_final.core.domain.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;

import java.util.List;

public interface ComentarioRepository {
    public void insert(Comentario comentario);
    public void update(int id, Comentario comentario);
    public void delete(int id);
    public Comentario getById(int id);
    public List<Comentario> fetch();
    public List<Comentario> getByProdutoId(int produto_id);
    public List<Comentario> getByUsuarioId(int usuario_id);
    public List<Comentario> getBySentimento(int sentimento);
}
