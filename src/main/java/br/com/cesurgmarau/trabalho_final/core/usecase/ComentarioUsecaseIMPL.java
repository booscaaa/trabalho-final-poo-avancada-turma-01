package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.Comentario.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.Comentario.ComentarioUsecase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioUsecaseIMPL implements ComentarioUsecase {

    @Autowired
    ComentarioRepository comentarioRepository;
    @Override
    public void cadastrarComentario(Comentario comentario) {
        comentarioRepository.cadastrarComentario(comentario);
    }

    @Override
    public List<Comentario> listarComentario() {
        return comentarioRepository.listarComentario();
    }

    @Override
    public Comentario getId(Long id) {
        return comentarioRepository.getId(id);
    }

    @Override
    public void atualizarComentario(Comentario comentario, Long id) {
        comentarioRepository.atualizarComentario(comentario, id);
    }

    @Override
    public void deletaComentario(Long id) {
        comentarioRepository.deletaComentario(id);
    }
}
