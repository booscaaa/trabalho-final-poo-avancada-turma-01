package br.com.cesurgmarau.trabalho_final.infra.reports;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.relatorio.RelatorioTotalSentimento;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Sentimento;
import java.util.ArrayList;
import java.util.List;

public class RelatorioTotalSentimentoString implements RelatorioTotalSentimento {

    @Override
    public String relatorioTotalSentimento(List<Sentimento> sentimentos, List<Double> sentimentoPorcentualList) {
        List<String> relatoriosSeparados = new ArrayList<>();
        int i = 0;

        for (Sentimento sentimento : sentimentos){
            relatoriosSeparados.add(sentimento.getTipo() + String.format(" %.2f%%", sentimentoPorcentualList.get(i)));
            i++;
        }

        return String.join( "\n", relatoriosSeparados);
    }
}
