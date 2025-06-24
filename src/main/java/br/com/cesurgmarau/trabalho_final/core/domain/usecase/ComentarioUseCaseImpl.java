package br.com.cesurgmarau.trabalho_final.core.domain.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.*;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.*;
import br.com.cesurgmarau.trabalho_final.core.dto.Comentario.ComentarioRequestDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ComentarioUseCaseImpl implements ComentarioUseCase {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    @Transactional
    public Comentario criarComentario(ComentarioRequestDTO dto) {
        Produto produto = produtoRepository.buscarPorId(dto.getProdutoId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        Usuario usuario = usuarioRepository.buscarPorId(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Comentario comentario = new Comentario();
        comentario.setProduto(produto);
        comentario.setUsuario(usuario);
        comentario.setTexto(dto.getTexto());
        comentario.setSentimento(TipoSentimento.NEUTRO); // você pode trocar depois
        comentario.setPontuacaoSentimento(null);

        return comentarioRepository.salvar(comentario);
    }

    @Override
    public Optional<Comentario> buscarPorId(Long id) {
        return comentarioRepository.buscarPorId(id);
    }

    @Override
    public List<Comentario> listarTodos() {
        return comentarioRepository.listarTodos();
    }

    @Override
    public List<Comentario> buscarPorProdutoId(Long produtoId) {
        return comentarioRepository.buscarPorProdutoId(produtoId);
    }

    @Override
    public List<Comentario> buscarPorUsuarioId(Long usuarioId) {
        return comentarioRepository.buscarPorUsuarioId(usuarioId);
    }

    @Override
    public List<Comentario> buscarPorSentimento(TipoSentimento sentimento) {
        return comentarioRepository.buscarPorSentimento(sentimento);
    }
}
