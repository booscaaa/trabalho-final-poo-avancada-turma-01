package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.gateway.AIGateway;
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
    private final AIGateway aIGateway;

    public ComentarioUseCaseImpl(ComentarioRepository comentarioRepository, AIGateway aIGateway) {
        this.comentarioRepository = comentarioRepository;
        this.aIGateway = aIGateway;
    }

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

    @Override
    public List<Comentario> readByProdutoId(Integer produtoId) {
        return comentarioRepository.findByProdutoId(produtoId);
    }

    @Override
    public List<Comentario> readByUsuarioId(Integer usuarioId) {
        return comentarioRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public int avaliarComentariosPendentes() {
        List<Comentario> comentarios = comentarioRepository.readComentarioByNullSentimento();

        for (Comentario comentario : comentarios) {
            int sentimento = aIGateway.classificarComentario(comentario.getTexto());
            comentario.setSentimento(sentimento);
            comentarioRepository.updateComentario(comentario.getId(), comentario);
        }

        return comentarios.size();
    }
}
