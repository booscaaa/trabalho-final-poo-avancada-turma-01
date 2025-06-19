package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.RelatorioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioSentimentosResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioUsuarioResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioProdutoResponse;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.util.SentimentoUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.Comparator;

@Repository
public class RelatorioRepositoryImpl implements RelatorioRepository {

    private final ComentarioRepository comentarioRepository;

    public RelatorioRepositoryImpl(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public List<RelatorioSentimentosResponse> totalComentariosPorSentimento() {
        List<Comentario> comentarios = comentarioRepository.buscarTodos();

        Map<String, Long> agrupado = comentarios.stream()
                .collect(Collectors.groupingBy(
                        Comentario::getSentimento,
                        Collectors.counting()
                ));

        return agrupado.entrySet().stream()
                .map(entry -> new RelatorioSentimentosResponse(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    @Override
    public List<RelatorioProdutoResponse> mediaSentimentoPorProduto() {
        List<Comentario> comentarios = comentarioRepository.buscarTodos();

        Map<Integer, List<Comentario>> agrupadoPorProduto = comentarios.stream()
                .collect(Collectors.groupingBy(Comentario::getProdutoId));

        return agrupadoPorProduto.entrySet().stream()
                .map(entry -> {
                    Integer produtoId = entry.getKey();
                    List<Comentario> comentariosDoProduto = entry.getValue();

                    double media = comentariosDoProduto.stream()
                            .mapToInt(c -> SentimentoUtils.converterSentimentoParaPontuacao(c.getSentimento()))
                            .average()
                            .orElse(0.0);

                    return new RelatorioProdutoResponse(produtoId, media);
                })
                .collect(Collectors.toList());
    }

    @Override
    public List<RelatorioUsuarioResponse> rankingUsuariosMaisAtivos() {
        List<Comentario> comentarios = comentarioRepository.buscarTodos();

        Map<Integer, Long> agrupadoPorUsuario = comentarios.stream()
                .collect(Collectors.groupingBy(
                        Comentario::getUsuarioId,
                        Collectors.counting()
                ));

        return agrupadoPorUsuario.entrySet().stream()
                .map(entry -> new RelatorioUsuarioResponse(entry.getKey(), entry.getValue()))
                .sorted(Comparator.comparing(RelatorioUsuarioResponse::getQuantidadeComentarios).reversed())
                .collect(Collectors.toList());
    }
}
