package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.*;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio.RelatorioProdutoOrdenarPorCategoria;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio.RelatorioUsuarioMaisAtivo;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Categoria;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Sentimento;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio.RelatorioMediaPorProduto;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio.RelatorioTotalSentimento;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RelatorioUseCaseImpl implements RelatorioUseCase {

    @Autowired
    SentimentoRepository sentimentoRepository;
    @Autowired
    ProdutoRepository produtoRepository;
    @Autowired
    RelatorioRepository relatorioRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    QuickSortUsuario quickSortUsuario;
    @Autowired
    CategoriaRepository categoriaRepository;

    @Override
    public String relatorioTotalSentimento(RelatorioTotalSentimento relatorioTotalSentimento) {
        List<Sentimento> sentimentos = sentimentoRepository.listarSentimentos();
        List<Double> sentimentoPorcentualList = new ArrayList<>();

        for(Sentimento sentimento : sentimentos){
            sentimentoPorcentualList.add(relatorioRepository.listarPorcentagemDeComentario(sentimento.getId()));
        }

        return relatorioTotalSentimento.relatorioTotalSentimento(sentimentos, sentimentoPorcentualList);
    }

    @Override
    public String relatorioMediaPorProduto(int produtoId, RelatorioMediaPorProduto relatorioMediaPorProduto) {
        Produto produto = produtoRepository.listarProdutoPorId(produtoId);
        List<Sentimento> sentimentos = sentimentoRepository.listarSentimentos();
        List<Double> sentimentoPorcentualList = new ArrayList<>();

        for (Sentimento sentimento : sentimentos){
            double quantidadeComentario = relatorioRepository.listarPorcentagemDeComentarioPorProdutoId(produtoId, sentimento.getId());
            sentimentoPorcentualList.add(quantidadeComentario);
        }

        return relatorioMediaPorProduto.relatorioMediaPorProduto(produto, sentimentos, sentimentoPorcentualList);
    }

    @Override
    public String RelatorioUsuarioMaisAtivo(RelatorioUsuarioMaisAtivo relatorioUsuarioMaisAtivo) {
        List<Usuario> usuarioList = usuarioRepository.listarUsuarios();
        quickSortUsuario.quickSort(usuarioList, 0, usuarioList.size() - 1);
        return relatorioUsuarioMaisAtivo.relatorioUsuarioMaisAtivo(usuarioList);
    }

    @Override
    public String relatorioProdutoDestaquesCategoria(int categoriaId, RelatorioProdutoOrdenarPorCategoria relatorioProdutoOrdenarPorCategoria) {
        Categoria categoria = categoriaRepository.listarCategoriaPorId(categoriaId);
        List<Produto> produtoList = produtoRepository.listarProdutosPorCategoria(categoriaId);

        return relatorioProdutoOrdenarPorCategoria.relatorioProdutoOrdenarPorCategoria(categoria, produtoList);
    }
}
