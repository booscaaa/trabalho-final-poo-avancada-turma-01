package br.com.cesurgmarau.trabalho_final.application.UseCase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ReportRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ReportUseCase;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportUseCaseImpl implements ReportUseCase {

    private final ReportRepository reportRepository;

    public ReportUseCaseImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }


    @Override
    public Map<String, Object> getCommentCountByFeelingId(int id) {
        List<Object[]> result = reportRepository.getCommentCountByFeelingId(id);

        if (result.isEmpty()) {
            Map<String, Object> response = new HashMap<>();
            response.put("mensagem", "Não existe nenhum comentário com esse sentimento.");
            return response;
        }

        Object[] line = result.get(0);
        String feeling = (String) line[0];
        Long total = ((Number) line[1]).longValue();

        Map<String, Object> response = new HashMap<>();
        response.put("Feeling", feeling);
        response.put("total", total);

        return response;
    }

    @Override
    public Map<String, Object> getAverageFeelingByProductId(int id) {
        List<Object[]> data = reportRepository.getFeelingDataByProductId(id);

        if (data.isEmpty()) {
            return Map.of("mensagem", "Nenhum comentário encontrado para esse produto.");
        }

        String productName = (String) data.get(0)[0];

        double sum = 0;
        int count = 0;

        for (Object[] row : data) {
            Number value = (Number) row[2];
            if (value != null) {
                sum += value.doubleValue();
                count++;
            }
        }

        if (count == 0) {
            return Map.of("mensagem", "Sentimentos sem valor válido para esse produto.");
        }

        double average = sum / count;
        double rounded = Math.round(average * 100.0) / 100.0;

        Map<String, Object> response = new HashMap<>();
        response.put("produto", productName);
        response.put("media_sentimento",rounded);
        response.put("interpretacao", interpretAverage(rounded));

        return response;
    }




    @Override
    public List<Map<String, Object>> getUserRanking() {
        List<Object[]> rows = reportRepository.getUserRanking();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Object[] row : rows) {
            String user = (String) row[0];
            Long total = ((Number) row[1]).longValue();

            Map<String, Object> map = new HashMap<>();
            map.put("usuario", user);
            map.put("total_comentarios", total);
            result.add(map);
        }

        return result;
    }

    private String interpretAverage(double average) {
        if (average < 1.5) return "Very Negative";
        else if (average < 2) return "Negative";
        else if (average < 3.5) return "Neutral";
        else if (average < 4.0) return "Positive";
        else return "Very Positive";
    }

    @Override
    public Map<String, Object> getSystemOverview() {
        Long totalUsers = reportRepository.countUsers();
        Long totalProducts = reportRepository.countProducts();
        Long totalComments = reportRepository.countComments();
        Double avgFeeling = reportRepository.averageFeeling();
        Object[] topProduct = reportRepository.topProduct();
        Object[] topUser = reportRepository.topUser();

        Map<String, Object> data = new HashMap<>();
        data.put("total_usuarios", totalUsers);
        data.put("total_produtos", totalProducts);
        data.put("comentarios_totais", totalComments);
        data.put("media_geral_sentimentos", Math.round(avgFeeling * 100.0) / 100.0);
        data.put("produto_mais_comentado", topProduct[0]);
        data.put("usuario_mais_ativo", topUser[0]);

        return data;
    }
}
