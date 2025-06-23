package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.livro.LivroRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio.RelatorioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usuario.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Livro;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioComentarioDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioProdutoDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.RelatorioUsuarioDTO;

import java.util.*;
import java.util.stream.Collectors;

public class RelatorioUseCaseImpl implements RelatorioUseCase {

    private final ComentarioRepository comentarioRepository;
    private final LivroRepository livroRepository;
    private final UsuarioRepository usuarioRepository;

    public RelatorioUseCaseImpl(ComentarioRepository comentarioRepository, LivroRepository livroRepository, UsuarioRepository usuarioRepository) {
        this.comentarioRepository = comentarioRepository;
        this.livroRepository = livroRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // 1. Total de comentários por sentimento (1 a 5)
    @Override
    public List<RelatorioComentarioDTO> totalComentariosPorSentimento() {
        List<Comentario> comentarios = comentarioRepository.buscarTodos();

        Map<Integer, Long> contagem = comentarios.stream()
                .collect(Collectors.groupingBy(
                        Comentario::getNotaSentimento,
                        Collectors.counting()
                ));

        // Garante que todas as notas de 1 a 5 estejam presentes
        for (int i = 1; i <= 5; i++) {
            contagem.putIfAbsent(i, 0L);
        }

        return contagem.entrySet().stream()
                .map(entry -> new RelatorioComentarioDTO.map(entry -> new RelatorioComentarioDTO(entry.getKey(), entry.getValue(), 0L))
                .sorted(Comparator.comparingInt(RelatorioComentarioDTO::getNota))
                .collect(Collectors.toList());
    }

    // 2. Média de sentimento por produto
    @Override
    public List<RelatorioProdutoDTO> mediaSentimentoPorProduto() {
        List<Comentario> comentarios = comentarioRepository.buscarTodos();
        List<Livro> livros = livroRepository.buscarTodos();

        Map<Integer, List<Comentario>> agrupadoPorLivro = comentarios.stream()
                .collect(Collectors.groupingBy(Comentario::getLivroId));

        return agrupadoPorLivro.entrySet().stream()
                .map(entry -> {
                    int livroId = entry.getKey();
                    List<Comentario> comentariosDoLivro = entry.getValue();
                    double media = comentariosDoLivro.stream()
                            .mapToInt(Comentario::getNotaSentimento)
                            .average()
                            .orElse(0.0);

                    String titulo = livros.stream()
                            .filter(l -> l.getId() == livroId)
                            .map(Livro::getTitulo)
                            .findFirst()
                            .orElse("Desconhecido");

                    return new RelatorioProdutoDTO(livroId, titulo, media);
                })
                .sorted(Comparator.comparingDouble(RelatorioProdutoDTO::getMediaSentimento).reversed())
                .collect(Collectors.toList());
    }

    // 3. Ranking de usuários mais ativos
    @Override
    public List<RelatorioUsuarioDTO> rankingUsuariosMaisAtivos() {
        List<Comentario> comentarios = comentarioRepository.buscarTodos();
        List<Usuario> usuarios = usuarioRepository.buscarTodos();

        Map<Integer, Long> contagemPorUsuario = comentarios.stream()
                .collect(Collectors.groupingBy(Comentario::getUsuarioId, Collectors.counting()));

        return contagemPorUsuario.entrySet().stream()
                .map(entry -> {
                    int usuarioId = entry.getKey();
                    long total = entry.getValue();
                    String nome = usuarios.stream()
                            .filter(u -> u.getId() != null && u.getId().equals(usuarioId))
                            .map(Usuario::getNome)
                            .findFirst()
                            .orElse("Desconhecido");

                    return new RelatorioUsuarioDTO(usuarioId, nome, total);
                })
                .sorted(Comparator.comparingLong(RelatorioUsuarioDTO::getTotalComentarios).reversed())
                .collect(Collectors.toList());
    }
}