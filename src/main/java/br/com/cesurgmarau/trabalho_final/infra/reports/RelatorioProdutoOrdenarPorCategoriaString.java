package br.com.cesurgmarau.trabalho_final.infra.reports;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio.RelatorioProdutoOrdenarPorCategoria;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Categoria;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Sentimento;

import java.util.ArrayList;
import java.util.List;

public class RelatorioProdutoOrdenarPorCategoriaString implements RelatorioProdutoOrdenarPorCategoria {
    @Override
    public String relatorioProdutoOrdenarPorCategoria(Categoria categoria, List<Produto> produtoList) {
        List<String> relatoriosSeparados = new ArrayList<>();

        for (Produto produto : produtoList){
            relatoriosSeparados.add(produto.getNome() + ": " + produto.getPontuacao() + " pontuação.");
        }

        return categoria.getNome() + ": \n" +  String.join( "\n", relatoriosSeparados );
    }
}
