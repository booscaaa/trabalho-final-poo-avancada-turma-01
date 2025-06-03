package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioRequest;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioResponse;

public interface CriarComentarioUsecase {
    ComentarioResponse criar(ComentarioRequest comentarioRequest);
}
