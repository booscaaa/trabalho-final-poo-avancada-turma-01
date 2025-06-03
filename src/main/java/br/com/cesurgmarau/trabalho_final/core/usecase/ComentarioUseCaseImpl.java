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
        sentimentoRepository.atualizarSentimento(sentimento.getId(), sentimento);

        Produto produto = produtoRepository.listarProdutoPorId(comentario.getProdutoId());
        produto.setPontuacao(produto.getPontuacao() + sentimento.getPonto());
        produtoRepository.atualizarProduto(produto.getId(), produto);

        Usuario usuario = usuarioRepository.listarUsuarioPorId(comentario.getUsuarioId());
        usuario.setQuantidadeComentario(usuario.getQuantidadeComentario() + 1);
        usuarioRepository.atualizarUsuario(usuario.getId(), usuario);

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
    public ComentarioPorProdutoDTO listarProdutoComComentarios(int produto_id) {
        Produto produto = produtoRepository.listarProdutoPorId(produto_id);
        List<ComentarioDTO> comentarioDTOs = comentarioRepository.listarComentarioPorProduto(produto_id);

        ComentarioPorProdutoDTO comentarioPorProdutoDTO = new ComentarioPorProdutoDTO(
                produto.getId(),
                produto.getNome(),
                produto.getPontuacao(),
                produto.getCategoriaId(),
                comentarioDTOs
        );

        return comentarioPorProdutoDTO;
    }

    @Override
    public ComentarioPorUsuarioDTO listarUsuarioComComentario(int usuario_id) {
        Usuario usuario = usuarioRepository.listarUsuarioPorId(usuario_id);
        List<ComentarioDTO> comentarioDTOs = comentarioRepository.listarUsuarioComComentario(usuario_id);

        ComentarioPorUsuarioDTO comentarioPorUsuarioDTO = new ComentarioPorUsuarioDTO(
                usuario.getId(),
                usuario.getCpf(),
                usuario.getNome(),
                comentarioDTOs
        );

        return comentarioPorUsuarioDTO;
    }

    @Override
    public ComentarioPorSentimentoDTO listarComentarioPorSentimento(int sentimento_id) {
        Sentimento sentimento = sentimentoRepository.pegarSentimentoId(sentimento_id);
        List<ComentarioDTO> comentarioDTOs = comentarioRepository.listarComentarioPorSentimento(sentimento_id);

        ComentarioPorSentimentoDTO comentarioPorSentimentoDTO = new ComentarioPorSentimentoDTO(
                sentimento.getId(),
                sentimento.getTipo(),
                sentimento.getPonto(),
                sentimento.getQuantidade(),
                comentarioDTOs
        );

        return comentarioPorSentimentoDTO;

    }


}
