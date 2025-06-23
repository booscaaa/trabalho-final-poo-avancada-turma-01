package br.com.cesurgmarau.trabalho_final.infra.repository.database;


import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.livro.LivroRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio.RelatorioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usuario.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Livro;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioComentarioDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioProdutoDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class RelatorioRepositoryImpl implements RelatorioRepository {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    private int converterSentimentoParaPontuacao(String sentimento) {
        switch (sentimento) {
            case "Muito Positivo": return 5;
            case "Positivo": return 4;
            case "Neutro": return 3;
            case "Negativo": return 2;
            case "Muito Negativo": return 1;
            default: return 3;
        }
    }

    @Override
    public List<RelatorioComentarioDTO> totalComentariosPorSentimento() {
        List<Comentario> comentarios = comentarioRepository.buscarTodosOsComentarios();

        Map<String, Long> agrupado = comentarios.stream()
                .collect(Collectors.groupingBy(Comentario::getSentimento, Collectors.counting()));

        List<RelatorioComentarioDTO> resultado = new ArrayList<>();
        String[] sentimentos = {"Muito Negativo", "Negativo", "Neutro", "Positivo", "Muito Positivo"};

        for (String sentimento : sentimentos) {
            long total = agrupado.getOrDefault(sentimento, 0L);
            int nota = converterSentimentoParaPontuacao(sentimento);
            resultado.add(new RelatorioComentarioDTO(sentimento, nota, total));
        }

        return resultado;
    }

    @Override
    public List<RelatorioProdutoDTO> mediaSentimentoPorProduto() {
        List<Comentario> comentarios = comentarioRepository.buscarTodosOsComentarios();

        Map<Integer, List<Comentario>> agrupadoPorLivro = comentarios.stream()
                .collect(Collectors.groupingBy(Comentario::getLivroId));

        List<RelatorioProdutoDTO> resultado = new ArrayList<>();

        for (Map.Entry<Integer, List<Comentario>> entry : agrupadoPorLivro.entrySet()) {
            int livroId = entry.getKey();
            List<Comentario> comentariosLivro = entry.getValue();

            double media = comentariosLivro.stream()
                    .mapToInt(c -> converterSentimentoParaPontuacao(c.getSentimento()))
                    .average()
                    .orElse(0.0);

            Optional<Livro> livroEncontrado = livroRepository.buscarTodos().stream()
                    .filter(l -> l.getId() == livroId)
                    .findFirst();
            String titulo = livroEncontrado.map(Livro::getTitulo).orElse("Livro desconhecido");

            resultado.add(new RelatorioProdutoDTO(livroId, titulo, media));
        }

        return resultado;
    }

    @Override
    public List<RelatorioUsuarioDTO> rankingUsuariosMaisAtivos() {
        List<Comentario> comentarios = comentarioRepository.buscarTodosOsComentarios();

        Map<Integer, Long> contagem = comentarios.stream()
                .collect(Collectors.groupingBy(Comentario::getUsuarioId, Collectors.counting()));

        return contagem.entrySet().stream()
                .sorted(Map.Entry.<Integer, Long>comparingByValue().reversed())
                .map(entry -> {
                    Integer usuarioId = entry.getKey();
                    long total = entry.getValue();
                    Optional<Usuario> usuarioEncontrado = usuarioRepository.buscarTodos().stream()
                            .filter(u -> u.getId())
                            .findFirst();
                    String nome = usuarioEncontrado.map(Usuario::getNome).orElse("Usuário desconhecido");
                    return new RelatorioUsuarioDTO(usuarioId, nome, total);
                })
                .collect(Collectors.toList());
    }
}

