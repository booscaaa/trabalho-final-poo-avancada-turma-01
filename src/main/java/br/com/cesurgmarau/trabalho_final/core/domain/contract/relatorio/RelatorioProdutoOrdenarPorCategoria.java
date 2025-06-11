package br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Categoria;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.infra.reports.RelatorioProdutoOrdenarPorCategoriaString;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = RelatorioProdutoOrdenarPorCategoriaString.class, name = "RelatorioProdutoOrdenarPorCategoriaString"),
})
public interface RelatorioProdutoOrdenarPorCategoria {
    public String relatorioProdutoOrdenarPorCategoria (Categoria categoria, List<Produto> produtoList);
}
