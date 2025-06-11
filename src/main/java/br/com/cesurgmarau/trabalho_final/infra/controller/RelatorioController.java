package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.RelatorioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio.RelatorioMediaPorProduto;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio.RelatorioProdutoOrdenarPorCategoria;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio.RelatorioTotalSentimento;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio.RelatorioUsuarioMaisAtivo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RelatorioController {

    @Autowired
    RelatorioUseCase relatorioUseCase;

    @GetMapping("/relatorio/sentimentos")
    public String relatorioTotal (@RequestBody RelatorioTotalSentimento relatorioTotalSentimento){
        return relatorioUseCase.relatorioTotalSentimento(relatorioTotalSentimento);
    }

    @GetMapping("/relatorio/{produtoId}")
    public String relatorioProduto (@PathVariable int produtoId,@RequestBody RelatorioMediaPorProduto relatorioMediaPorProduto){
        return relatorioUseCase.relatorioMediaPorProduto(produtoId, relatorioMediaPorProduto);
    }

    @GetMapping("/relatorio/usuarios")
    public String relatorioUsuario (@RequestBody RelatorioUsuarioMaisAtivo relatorioUsuarioMaisAtivo){
        return relatorioUseCase.RelatorioUsuarioMaisAtivo(relatorioUsuarioMaisAtivo);
    }

    @GetMapping("/relatorio/categoria/{categoriaId}")
    public String relatorioProdutoDestaquesCategoria(@PathVariable int categoriaId, @RequestBody RelatorioProdutoOrdenarPorCategoria relatorioProdutoOrdenarPorCategoria){
        return relatorioUseCase.relatorioProdutoDestaquesCategoria(categoriaId, relatorioProdutoOrdenarPorCategoria);
    }
}
