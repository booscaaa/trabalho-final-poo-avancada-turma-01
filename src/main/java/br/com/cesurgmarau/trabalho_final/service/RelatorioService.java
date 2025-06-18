package br.com.cesurgmarau.trabalho_final.service;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.dto.RelatorioDTO;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RelatorioService {

    private final ComentarioRepository comentarioRepository;

    public RelatorioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    public RelatorioDTO gerarRelatorio() {
        List<Comentario> comentarios = comentarioRepository.findAll();

        Map<Integer, Long> sentimentoPorProduto = comentarios.stream()
                .filter(c -> c.getSentimento() != null)
                .filter(c -> c.getSentimento().equalsIgnoreCase("positivo") || c.getSentimento().equalsIgnoreCase("muito positivo"))
                .collect(Collectors.groupingBy(
                        Comentario::getId_produto, // já é int, pode usar direto
                        Collectors.counting()
                ));

        Map<Integer, Long> sentimentoPorUsuario = comentarios.stream()
                .filter(c -> c.getSentimento() != null)
                .filter(c -> c.getSentimento().equalsIgnoreCase("positivo") || c.getSentimento().equalsIgnoreCase("muito positivo"))
                .collect(Collectors.groupingBy(
                        Comentario::getId_usuario, // já é int, pode usar direto
                        Collectors.counting()
                ));
        String produtoDestaque = sentimentoPorProduto.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(e -> "Produto ID " + e.getKey())
                .orElse("N/A");

        String usuarioDestaque = sentimentoPorUsuario.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(e -> "Usuário ID " + e.getKey())
                .orElse("N/A");

        return new RelatorioDTO(sentimentoPorProduto, sentimentoPorUsuario, produtoDestaque, usuarioDestaque);
    }
}