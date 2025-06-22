package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioUsecase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.infra.ai.OpenAiService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioUsecaseImpl implements ComentarioUsecase {

    private final ComentarioRepository comentarioRepository;
    private final OpenAiService openAiService;

    public ComentarioUsecaseImpl(ComentarioRepository comentarioRepository, OpenAiService openAiService) {
        this.comentarioRepository = comentarioRepository;
        this.openAiService = openAiService;
    }

    @Override
    public Comentario criar(Comentario comentario) {
        String sentimento = openAiService.analisarSentimento(comentario.getTexto());
        comentario.setSentimento(sentimento);
        return comentarioRepository.salvar(comentario);
    }


    @Override
    public Comentario buscarPorId(Integer id) {
        return comentarioRepository.buscarPorId(id).orElse(null);
    }

    @Override
    public List<Comentario> listarTodos() {
        return comentarioRepository.buscarTodos();
    }

    @Override
    public List<Comentario> buscarPorProdutoId(Integer produtoId) {
        return comentarioRepository.buscarPorProdutoId(produtoId);
    }

    @Override
    public List<Comentario> buscarPorUsuarioId(Integer usuarioId) {
        return comentarioRepository.buscarPorUsuarioId(usuarioId);
    }

    @Override
    public List<Comentario> buscarPorSentimento(String sentimento) {
        return comentarioRepository.buscarPorSentimento(sentimento);
    }

    @Override
    public List<Comentario> buscarFiltrado(Integer produtoId, Integer usuarioId, String sentimento) {
        if (produtoId != null) return buscarPorProdutoId(produtoId);
        if (usuarioId != null) return buscarPorUsuarioId(usuarioId);
        if (sentimento != null) return buscarPorSentimento(sentimento);
        return listarTodos();
    }

    @Override
    public void deletar(Integer id) {
        comentarioRepository.deletar(id);
    }
}