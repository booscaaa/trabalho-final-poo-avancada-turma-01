package br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Sentimento;
import br.com.cesurgmarau.trabalho_final.infra.reports.RelatorioTotalSentimentoString;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.List;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "tipo"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = RelatorioTotalSentimentoString.class, name = "RelatorioTotalString"),
})
public interface RelatorioTotalSentimento {
    public String relatorioTotalSentimento (List<Sentimento> sentimentos, List<Double> sentimentoPorcentualList);
}
