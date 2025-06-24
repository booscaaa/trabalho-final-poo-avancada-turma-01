package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.RelatorioDestaqueUsecase;
import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoDestaqueResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.UsuarioDestaqueResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioDestaqueUsecaseImpl implements RelatorioDestaqueUsecase {

    private final ComentarioRepository comentarioRepository;

    public RelatorioDestaqueUsecaseImpl(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    @Override
    public List<UsuarioDestaqueResponse> listarUsuariosEmDestaque() {
        return comentarioRepository.buscarUsuariosComMaisComentariosPositivos();
    }

    @Override
    public List<ProdutoDestaqueResponse> listarProdutosEmDestaque() {
        return comentarioRepository.buscarProdutosComMaisSentimentosPositivos();
    }
}
