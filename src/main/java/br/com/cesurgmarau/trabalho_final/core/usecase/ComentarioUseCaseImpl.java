package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.*;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Sentimento;
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

    @Override
    public void adicionarComentario(Comentario comentario) throws IOException {
        String tipoSentimento = chatGPTGateway.identificarSentimento(comentario.getComentario());
        Sentimento sentimento = sentimentoRepository.pegarSentimentoId(tipoSentimento);
        comentario.setSentimentoId(sentimento.getId());
        sentimento.setQuantidade(sentimento.getQuantidade() + 1);
        sentimentoRepository.atualizarSentimento(sentimento.getId(), sentimento);

        Produto produto = produtoRepository.listarProdutoPorId(comentario.getProdutoId());
        produto.setPontuacao(produto.getPontuacao() + sentimento.getPonto());
        produtoRepository.atualizarProduto(produto.getId(), produto);

        comentarioRepository.adicionarComentario(comentario);
    }

    @Override
    public Comentario listarComentarioPorId(int id) {
        return null;
    }

    @Override
    public List<Comentario> listarComentario() {
        return List.of();
    }
}
