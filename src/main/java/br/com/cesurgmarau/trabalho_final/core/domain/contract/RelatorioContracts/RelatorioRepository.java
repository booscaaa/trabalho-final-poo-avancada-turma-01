package br.com.cesurgmarau.trabalho_final.core.domain.contract.RelatorioContracts;

import java.util.List;
import java.util.Objects;

public interface RelatorioRepository {
    List<Objects[]> relatorioSentimentos();
    List<Object[]> mediaProdutos();
    List<Object[]> usuarioMaisAtivo();
}
