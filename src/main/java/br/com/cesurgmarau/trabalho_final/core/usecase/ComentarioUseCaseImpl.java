package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComentarioUseCaseImpl implements ComentarioUseCase {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Override
    public List<Comentario> listar() {
        return comentarioRepository.listar();
    }

    @Override
    public Comentario listarPorId(int id) {
        return comentarioRepository.listarPorId(id);
    }

    @Override
    public void adicionarComentario(Comentario comentario) {
        comentarioRepository.adicionarComentario(comentario);
    }

    @Override
    public String deletarComentario(int id) {
        return comentarioRepository.deletarComentario(id);
    }

    @Override
    public String atualizarComentario(int id, Comentario comentario) {
        return comentarioRepository.atualizarComentario(id, comentario);
    }

}
