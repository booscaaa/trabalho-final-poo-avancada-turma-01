package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.repository.ComentarioRepository;

import java.util.List;

public class ComentarioUseCaseImpl implements ComentarioUseCase {

    private ComentarioRepository comentariorepository;

    @Override
    public void insert(Comentario comentario) {
        comentariorepository.insert(comentario);
    }

    @Override
    public void update(int id, Comentario comentario) {
        comentariorepository.update(id, comentario);
    }

    @Override
    public void delete(int id) {
        comentariorepository.delete(id);
    }

    @Override
    public Comentario getById(int id) {
        return comentariorepository.getById(id);
    }

    @Override
    public List<Comentario> fetch() {
        return comentariorepository.fetch();
    }

    @Override
    public List<Comentario> getByProdutoId(int produto_Id) {
        return comentariorepository.getByProdutoId(produto_Id);
    }

    @Override
    public List<Comentario> getByUsuarioId(int usuario_Id) {
        return comentariorepository.getByUsuarioId(usuario_Id);
    }

    @Override
    public List<Comentario> getBySentimento(String sentimento) {
        return comentariorepository.getBySentimento(sentimento);
    }
}
