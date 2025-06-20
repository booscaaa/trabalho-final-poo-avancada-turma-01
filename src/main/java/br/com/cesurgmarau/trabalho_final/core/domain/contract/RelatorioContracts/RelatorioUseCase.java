package br.com.cesurgmarau.trabalho_final.core.domain.contract.RelatorioContracts;

import br.com.cesurgmarau.trabalho_final.core.domain.dto.MediaProdutoDto;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.UsuarioAtivoDto;

import java.util.List;
import java.util.Objects;

public interface RelatorioUseCase {
    List<Objects[]> relatorioSentimentos();
    List<MediaProdutoDto> mediaProdutos();
    List<UsuarioAtivoDto> usuarioMaisAtivo();
}
