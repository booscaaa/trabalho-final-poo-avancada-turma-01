package br.com.cesurgmarau.trabalho_final.core.domain.contract.Relatorios.RelatoriosProduto;

import br.com.cesurgmarau.trabalho_final.core.dto.MediaSentimentoProdutoOutput.MediaSentimentoProdutoOutput;

import java.util.List;

public interface RelatoriosProdutoRepository {

    // void listarComentariosMelhorAvaliadosProduto (int idproduto);
//
    // void listarComentariosPiorAvaliadosProduto (int idproduto);
//
    // void relatorioAvaliacoesProduto (int idproduto);
//
    // void listarProdutosMelhoresAvaliados (int idproduto);
//
    // void listarProdutosPioresAvaliados (int idproduto);

    List<MediaSentimentoProdutoOutput> mediaDeSentimentoPorProduto ();

}