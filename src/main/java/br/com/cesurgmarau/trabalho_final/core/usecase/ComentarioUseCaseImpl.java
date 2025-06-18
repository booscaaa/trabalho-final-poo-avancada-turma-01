package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.*;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Sentimento;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioPorSentimentoDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioPorProdutoDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioPorUsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ComentarioUseCaseImpl implements ComentarioUseCase {

    @Autowired
    private ComentarioRepository comentarioRepository;
    @Autowired
    private ChatGPTGateway chatGPTGateway;
    @Autowired
    private SentimentoRepository sentimentoRepository;
    @Autowired
    private ProdutoRepository produtoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void adicionarComentario(Comentario comentario) throws IOException {
        String tipoSentimento = chatGPTGateway.identificarSentimento(comentario.getComentario());
        Sentimento sentimento = sentimentoRepository.pegarTipoSentimento(tipoSentimento);
        comentario.setSentimentoId(sentimento.getId());
        sentimento.setQuantidade(sentimento.getQuantidade() + 1);
        produtoRepository.adicionarQuantidadeComentario(comentario.getProdutoId());
        sentimentoRepository.atualizarSentimento(sentimento.getId(), sentimento);

        produtoRepository.atualizarPontuacao(comentario.getProdutoId(), sentimento.getPonto());

        usuarioRepository.atualizarQuantidadeComentario(comentario.getUsuarioId(), 1);

        comentarioRepository.adicionarComentario(comentario);
    }

    @Override
    public ComentarioDTO listarComentarioPorId(int id) {
        return comentarioRepository.listarComentarioPorId(id);
    }

    @Override
    public List<ComentarioDTO> listarComentario() {
        return comentarioRepository.listarComentario();
    }

    @Override
    public ComentarioPorProdutoDTO listarComentarioPorProduto(int produtoId) {
        Produto produto = produtoRepository.listarProdutoPorId(produtoId);
        List<ComentarioDTO> comentarioDTOList = comentarioRepository.listarComentarioPorProduto(produtoId);

        ComentarioPorProdutoDTO comentarioPorProdutoDTO = new ComentarioPorProdutoDTO(
                produto.getId(),
                produto.getNome(),
                produto.getPontuacao(),
                produto.getCategoriaId(),
                comentarioDTOList
        );

        return comentarioPorProdutoDTO;
    }

    @Override
    public ComentarioPorUsuarioDTO listarComentarioPorUsuario(int usuarioId) {
        Usuario usuario = usuarioRepository.listarUsuarioPorId(usuarioId);
        List<ComentarioDTO> comentarioDTOList = comentarioRepository.listarComentarioPorUsuario(usuarioId);

        ComentarioPorUsuarioDTO comentarioPorUsuarioDTO = new ComentarioPorUsuarioDTO(
                usuario.getId(),
                usuario.getCpf(),
                usuario.getNome(),
                comentarioDTOList
        );

        return comentarioPorUsuarioDTO;
    }

    @Override
    public ComentarioPorSentimentoDTO listarComentarioPorSentimento(int sentimentoId) {
        Sentimento sentimento = sentimentoRepository.pegarSentimentoId(sentimentoId);
        List<ComentarioDTO> comentarioDTOList = comentarioRepository.listarComentarioPorSentimento(sentimentoId);

        ComentarioPorSentimentoDTO comentarioPorSentimentoDTO = new ComentarioPorSentimentoDTO(
                sentimento.getId(),
                sentimento.getTipo(),
                sentimento.getPonto(),
                sentimento.getQuantidade(),
                comentarioDTOList
        );

        return comentarioPorSentimentoDTO;

    }


}
