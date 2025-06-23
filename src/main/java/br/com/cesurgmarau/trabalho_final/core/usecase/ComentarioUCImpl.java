package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.AnaliseSentimentoService;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioUCImpl implements ComentarioUseCase {

    @Autowired
    private ComentarioRepository comentarioRepository;
    @Autowired
    private AnaliseSentimentoService analiseSentimentoService;


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
    public List<Comentario> buscarTodosOsComentarios() {
        return (List<Comentario>) comentarioRepository.buscarTodosOsComentarios();
    }

    @Override
    public Comentario buscarComentarioPorId(int id) {
        return comentarioRepository.buscarComentarioPorId(id);
    }

    @Override
    public List<Comentario> buscarProdutoPorId(int livroId) {
        return (List<Comentario>) comentarioRepository.buscarProdutoPorId(livroId);
    }


    @Override
    public List<Comentario> buscarUsuarioPorId(int usuarioId) {
        return (List<Comentario>) comentarioRepository.buscarUsuarioPorId(usuarioId);
    }

    @Override
    public List<Comentario> buscarTodos() {
        return List.of();
    }
}
