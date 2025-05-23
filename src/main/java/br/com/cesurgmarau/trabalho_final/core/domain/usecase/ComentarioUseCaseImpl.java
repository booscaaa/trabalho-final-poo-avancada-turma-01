package br.com.cesurgmarau.trabalho_final.core.domain.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Comentario.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Comentario.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioUseCaseImpl implements ComentarioUseCase {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Override
    public void create(Comentario comentario) {
        comentarioRepository.create(comentario);
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
    public Comentario findById(int id) {
        return comentarioRepository.findById(id);
    }

    @Override
    public List<Comentario> fetch() {
        return comentarioRepository.fetch();
    }
}
