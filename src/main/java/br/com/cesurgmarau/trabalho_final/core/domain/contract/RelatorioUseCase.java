package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio.RelatorioMediaPorProduto;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio.RelatorioProdutoOrdenarPorCategoria;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio.RelatorioTotalSentimento;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio.RelatorioUsuarioMaisAtivo;

public interface RelatorioUseCase {
    public String relatorioTotalSentimento (RelatorioTotalSentimento relatorioTotalSentimento);
    public String relatorioMediaPorProduto(int produtoId, RelatorioMediaPorProduto relatorioMediaPorProduto);
    public String RelatorioUsuarioMaisAtivo(RelatorioUsuarioMaisAtivo relatorioUsuarioMaisAtivo);
    public String relatorioProdutoDestaquesCategoria(int categoriaId, RelatorioProdutoOrdenarPorCategoria relatorioProdutoOrdenarPorCategoria);
}
