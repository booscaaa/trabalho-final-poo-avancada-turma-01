package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.repository.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase.RelatorioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RelatorioUseCaseImpl implements RelatorioUseCase {

    private final ComentarioRepository comentarioRepository;

    public RelatorioUseCaseImpl(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public Map<Integer, Long> totalComentariosPorSentimento() {
        List<Comentario> comentarios = comentarioRepository.readComentario();
        return comentarios.stream()
                .filter(c -> c.getSentimento() != null)
                .collect(Collectors.groupingBy(
                        Comentario::getSentimento,
                        Collectors.counting()
                ));
    }

    @Override
    public Map<Integer, Double> mediaSentimentoPorProduto() {
        List<Comentario> comentarios = comentarioRepository.readComentario();

        Map<Integer, Double> media = comentarios.stream()
                .filter(c -> c.getSentimento() != null)
                .collect(Collectors.groupingBy(
                        c -> c.getProduto().getId(),
                        Collectors.averagingInt(Comentario::getSentimento)
                ));

        return media;
    }

    @Override
    public List<Map<String, Object>> rankingUsuariosMaisAtivos() {
        List<Comentario> comentarios = comentarioRepository.readComentario();

        return comentarios.stream()
                .collect(Collectors.groupingBy(
                        c -> c.getUsuario().getId(),
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .map(entry -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("usuarioId", entry.getKey());
                    map.put("quantidadeComentarios", entry.getValue());
                    return map;
                })
                .collect(Collectors.toList());
    }
}
