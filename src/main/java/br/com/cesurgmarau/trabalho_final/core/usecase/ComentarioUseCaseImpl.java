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
    public List<Comentario> buscaPorProdutoId(int produtoId) {
        return this.comentarioRepository.buscaPorProdutoId(produtoId);
    }

    @Override
    public List<Comentario> buscaPorUsuarioId(int usuarioId) {
        return this.comentarioRepository.buscaPorUsuarioId(usuarioId);
    }

    @Override
    public List<Comentario> buscaPorSentimento(String sentimento) {
        return this.comentarioRepository.buscaPorSentimento(sentimento);
    }

    @Override
    public DeepSeekResponse resposta(DeepSeekRequest request) throws Exception {
        return null;
    }
}
