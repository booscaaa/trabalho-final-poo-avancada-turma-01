package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoDestaqueResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.UsuarioDestaqueResponse;

import java.util.List;

public interface RelatorioDestaqueUsecase {
    List<UsuarioDestaqueResponse> listarUsuariosEmDestaque();
    List<ProdutoDestaqueResponse> listarProdutosEmDestaque();
}
