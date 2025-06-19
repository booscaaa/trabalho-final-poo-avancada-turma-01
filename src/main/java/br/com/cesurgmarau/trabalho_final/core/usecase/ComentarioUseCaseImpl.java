package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.repository.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioUseCaseImpl implements ComentarioUseCase {

    @Autowired
    ComentarioRepository comentarioRepository;

    @Override
    public void createComentario(Comentario comentario) {
        comentarioRepository.createComentario(comentario);
    }

    @Override
    public List<Comentario> readComentario() {
        return comentarioRepository.readComentario();
    }

    @Override
    public Comentario readComentario(Integer id) {
        return comentarioRepository.readComentario(id);
    }

    @Override
    public void updateComentario(Integer id, Comentario comentario) {
        comentarioRepository.updateComentario(id, comentario);
    }

    @Override
    public void deleteComentario(Integer id) {
        comentarioRepository.deleteComentario(id);
    }
}
