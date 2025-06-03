package br.com.cesurgmarau.trabalho_final.service;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.dto.RelatorioDTO;
import br.com.cesurgmarau.trabalho_final.infra.controller.ComentarioController;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class RelatorioService {

    private final ComentarioRepository comentarioRepository;

    public RelatorioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public RelatorioDTO gerarRelatorio() {
        List<Comentario> comentarios = comentarioRepository.findAll();

        Map<String, Long> sentimentoPorProduto = comentarios.stream()
                .filter(c -> c.getProduto() != null)
                .collect(Collectors.groupingBy(
                        c -> c.getProduto().getNome(),
                        Collectors.filtering(
                                c -> c.getSentimento().equalsIgnoreCase("positivo") || c.getSentimento().equalsIgnoreCase("muito positivo"),
                                Collectors.counting()
                        )
                ));

        Map<String, Long> sentimentoPorUsuario = comentarios.stream()
                .filter(c -> c.getUsuario() != null)
                .collect(Collectors.groupingBy(
                        c -> c.getUsuario().getNome(),
                        Collectors.filtering(
                                c -> c.getSentimento().equalsIgnoreCase("positivo") || c.getSentimento().equalsIgnoreCase("muito positivo"),
                                Collectors.counting()
                        )
                ));

        String produtoDestaque = sentimentoPorProduto.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("N/A");

        String usuarioDestaque = sentimentoPorUsuario.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse("N/A");

        return new RelatorioDTO(sentimentoPorProduto, sentimentoPorUsuario, produtoDestaque, usuarioDestaque);
    }
}



