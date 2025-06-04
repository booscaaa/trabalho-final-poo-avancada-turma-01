package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ComentarioUseCaseImpl implements ComentarioUseCase {
    @Autowired
    private ComentarioRepository comentarioRepository;

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
    public List<Comentario> fetch() {
        return comentarioRepository.fetch();
    }

    @Override
    public Comentario get(int id) {
       return comentarioRepository.get(id);
    }
}
