package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioUseCaseImpl implements ComentarioUseCase {

    private final ComentarioRepository comentarioRepository;

    public ComentarioUseCaseImpl(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public void insert(Comentario comentario) {
        comentarioRepository.insert(comentario);
    }

    @Override
    public void update(int id, Comentario comentario) {
        comentarioRepository.update(id, comentario);
    }

    @Override
    public void delete(int id) {
        comentarioRepository.delete(id);
    }

    @Override
    public Comentario getById(int id) {
        return comentarioRepository.getById(id);
    }

    @Override
    public List<Comentario> fetch() {
        return comentarioRepository.fetch();
    }

    @Override
    public List<Comentario> getByProdutoId(int produto_id) {
        return comentarioRepository.getByProdutoId(produto_id);
    }

    @Override
    public List<Comentario> getByUsuarioId(int usuario_id) {
        return comentarioRepository.getByUsuarioId(usuario_id);
    }

    @Override
    public List<Comentario> getBySentimento(int sentimento_id) {
        return comentarioRepository.getBySentimento(sentimento_id);
    }
}
