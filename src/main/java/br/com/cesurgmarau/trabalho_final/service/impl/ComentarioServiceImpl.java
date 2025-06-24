package br.com.cesurgmarau.trabalho_final.service.impl;

import br.com.cesurgmarau.trabalho_final.dto.ComentarioDTO;
import br.com.cesurgmarau.trabalho_final.dto.ComentarioRequestDTO;
import br.com.cesurgmarau.trabalho_final.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.entity.Produto;
import br.com.cesurgmarau.trabalho_final.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.exception.RecursoNaoEncontradoException;
import br.com.cesurgmarau.trabalho_final.integration.SentimentoAIClient;
import br.com.cesurgmarau.trabalho_final.repository.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.repository.ProdutoRepository;
import br.com.cesurgmarau.trabalho_final.repository.UsuarioRepository;
import br.com.cesurgmarau.trabalho_final.service.interfaces.ComentarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioServiceImpl implements ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private SentimentoAIClient sentimentoAIClient;

    @Override
    public ComentarioDTO salvar(ComentarioRequestDTO dto) {
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Usuário não encontrado"));
        Produto produto = produtoRepository.findById(dto.getProdutoId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Produto não encontrado"));

        String sentimento = sentimentoAIClient.analisarSentimento(dto.getTexto());

        Comentario comentario = new Comentario();
        comentario.setTexto(dto.getTexto());
        comentario.setSentimento(sentimento);
        comentario.setDataCriacao(LocalDateTime.now());
        comentario.setUsuario(usuario);
        comentario.setProduto(produto);

        Comentario salvo = comentarioRepository.save(comentario);

        return toDTO(salvo);
    }

    @Override
    public ComentarioDTO buscarPorId(Long id) {
        Comentario comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Comentário não encontrado"));
        return toDTO(comentario);
    }

    @Override
    public List<ComentarioDTO> listarTodos() {
        return comentarioRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ComentarioDTO> buscarPorProduto(Long produtoId) {
        return comentarioRepository.findByProdutoId(produtoId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ComentarioDTO> buscarPorUsuario(Long usuarioId) {
        return comentarioRepository.findByUsuarioId(usuarioId).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ComentarioDTO> buscarPorSentimento(String sentimento) {
        return comentarioRepository.findBySentimentoIgnoreCase(sentimento).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private ComentarioDTO toDTO(Comentario c) {
        ComentarioDTO dto = new ComentarioDTO();
        dto.setId(c.getId());
        dto.setTexto(c.getTexto());
        dto.setSentimento(c.getSentimento());
        dto.setDataCriacao(c.getDataCriacao());
        dto.setUsuarioId(c.getUsuario().getId());
        dto.setProdutoId(c.getProduto().getId());
        return dto;
    }
}
