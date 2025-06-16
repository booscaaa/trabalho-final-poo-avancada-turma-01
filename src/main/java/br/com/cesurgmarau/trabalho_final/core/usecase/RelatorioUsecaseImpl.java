package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.RelatorioUsecase;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioProdutoResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioSentimentosResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioUsuarioResponse;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RelatorioUsecaseImpl implements RelatorioUsecase {

    private final ComentarioRepository comentarioRepository;

    public RelatorioUsecaseImpl(ComentarioRepository comentarioRepository) {
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
                .toList();
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
                            .mapToInt(this::converterSentimentoParaPontuacao)
                            .average()
                            .orElse(0.0);

                    return new RelatorioProdutoResponse(produtoId, media);
                })
                .toList();
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
                .toList();
    }

    private int converterSentimentoParaPontuacao(Comentario comentario) {
        return switch (comentario.getSentimento().toLowerCase()) {
            case "muito negativo" -> 1;
            case "negativo" -> 2;
            case "neutro" -> 3;
            case "positivo" -> 4;
            case "muito positivo" -> 5;
            default -> 3;
        };
    }
}
