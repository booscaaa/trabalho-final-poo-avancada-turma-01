package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioRequest;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioResponse;

public class CriarComentarioUsecaseImpl implements CriarComentarioUsecase {

    private final ComentarioRepository comentarioRepository;

    public CriarComentarioUsecaseImpl(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public ComentarioResponse criar(ComentarioRequest comentarioRequest) {
        Comentario comentario = new Comentario();
        comentario.setTexto(comentarioRequest.getTexto());
        comentario.setSentimento(null);  // IMPLEMENTAR IA
        comentario.setUsuarioId(comentarioRequest.getUsuarioId());
        comentario.setProdutoId(comentarioRequest.getProdutoId());

        Comentario comentarioSalvo = comentarioRepository.salvar(comentario);

        ComentarioResponse response = new ComentarioResponse();
        response.setId(comentarioSalvo.getId());
        response.setTexto(comentarioSalvo.getTexto());
        response.setSentimento(comentarioSalvo.getSentimento());

        return response;
    }
}
