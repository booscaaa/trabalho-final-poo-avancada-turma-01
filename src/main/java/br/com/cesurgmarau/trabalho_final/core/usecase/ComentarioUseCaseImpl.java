package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioContracts.ComentarioGateway;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioContracts.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioContracts.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.DeepSeekRequest;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.DeepSeekResponse;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service("comentarioUseCaseImpl")
public class ComentarioUseCaseImpl implements ComentarioUseCase, ComentarioGateway {
    @Autowired

    private ComentarioRepository comentarioRepository;

    public ComentarioUseCaseImpl(ComentarioRepository comentarioRepository){
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public void adicionarComentario(Comentario comentario) {
        this.comentarioRepository.adicionarComentario(comentario);
    }

    @Override
    public List<Comentario> listarComentarios() {
        return this.comentarioRepository.listarComentarios();
    }

    @Override
    public Comentario comentarioPorId(int id) {
        return this.comentarioRepository.comentarioPorId(id);
    }

    @Override
    public void atualizarComentario(int id, Comentario comentario) {
        Comentario existente = this.comentarioRepository.comentarioPorId(id);
        if (existente == null) {
            throw new IllegalArgumentException("Comentário com ID fornecido não existe.");
        }

        this.comentarioRepository.atualizarComentario(id, comentario);
    }

    @Override
    public void deletarComentario(int id) {
        Comentario existente = this.comentarioRepository.comentarioPorId(id);
        if (existente == null) {
            throw new IllegalArgumentException("Comentário com ID fornecido não existe.");
        }

        this.comentarioRepository.deletarComentario(id);
    }

    @Override
    public DeepSeekResponse resposta(DeepSeekRequest request) throws Exception {
        return null;
    }
}
