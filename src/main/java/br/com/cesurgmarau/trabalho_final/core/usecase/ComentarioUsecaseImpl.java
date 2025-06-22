package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioUsecase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioRequest;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioResponse;
import br.com.cesurgmarau.trabalho_final.infra.ai.OpenAiService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComentarioUsecaseImpl implements ComentarioUsecase {

    private final ComentarioRepository comentarioRepository;
    private final OpenAiService openAiService;

    public ComentarioUsecaseImpl(ComentarioRepository comentarioRepository, OpenAiService openAiService) {
        this.comentarioRepository = comentarioRepository;
        this.openAiService = openAiService;
    }

    @Override
    public ComentarioResponse criar(ComentarioRequest request) {
        Comentario comentario = new Comentario();
        comentario.setTexto(request.getTexto());
        comentario.setUsuarioId(request.getUsuarioId());
        comentario.setProdutoId(request.getProdutoId());

        String sentimento = openAiService.analisarSentimento(request.getTexto());
        comentario.setSentimento(sentimento);

        Comentario salvo = comentarioRepository.salvar(comentario);
        return toResponse(salvo);
    }

    @Override
    public ComentarioResponse buscarPorId(Integer id) {
        Comentario comentario = comentarioRepository.buscarPorId(id)
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado com id: " + id));
        return toResponse(comentario);
    }

    @Override
    public List<ComentarioResponse> listarTodos() {
        return comentarioRepository.buscarTodos().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ComentarioResponse> buscarPorProdutoId(Integer produtoId) {
        return comentarioRepository.buscarPorProdutoId(produtoId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ComentarioResponse> buscarPorUsuarioId(Integer usuarioId) {
        return comentarioRepository.buscarPorUsuarioId(usuarioId).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ComentarioResponse> buscarPorSentimento(String sentimento) {
        return comentarioRepository.buscarPorSentimento(sentimento).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<ComentarioResponse> buscarFiltrado(Integer produtoId, Integer usuarioId, String sentimento) {
        if (produtoId != null) return buscarPorProdutoId(produtoId);
        if (usuarioId != null) return buscarPorUsuarioId(usuarioId);
        if (sentimento != null) return buscarPorSentimento(sentimento);
        return listarTodos();
    }

    @Override
    public void deletar(Integer id) {
        Optional<Comentario> comentarioOpt = comentarioRepository.buscarPorId(id);
        if (comentarioOpt.isEmpty()) {
            throw new RuntimeException("Comentário não encontrado");
        }
        comentarioRepository.deletar(id);
    }

    private ComentarioResponse toResponse(Comentario comentario) {
        ComentarioResponse response = new ComentarioResponse();
        response.setId(comentario.getId());
        response.setTexto(comentario.getTexto());
        response.setSentimento(comentario.getSentimento());
        response.setUsuarioId(comentario.getUsuarioId());
        response.setProdutoId(comentario.getProdutoId());
        return response;
    }
}