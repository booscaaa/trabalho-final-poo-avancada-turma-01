package br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Sentimento;
import br.com.cesurgmarau.trabalho_final.infra.reports.RelatorioMediaPorProdutoString;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = RelatorioMediaPorProdutoString.class, name = "RelatorioMediaPorProdutoString"),
})
public interface RelatorioMediaPorProduto {
    public String relatorioMediaPorProduto (Produto produto, List<Sentimento> sentimentos, List<Double> sentimentoPorcentualList);
}
