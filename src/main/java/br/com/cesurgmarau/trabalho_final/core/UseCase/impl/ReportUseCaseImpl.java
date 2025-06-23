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
    public Map<String, Object> getAverageFeelingByProductId(int productId) {
        List<Number> values = reportRepository.getFeelingValuesByProductId(productId);

        if (values.isEmpty()) {
            return Map.of("mensagem", "Nenhum comentário encontrado para esse produto.");
        }

        double sum = 0;
        int count = 0;
        for (Number n : values) {
            if (n != null) {
                sum += n.doubleValue();
                count++;
            }
        }

        if (count == 0) {
            return Map.of("mensagem", "Nenhum comentário com valor de sentimento válido encontrado.");
        }

        double average = sum / count;

        Map<String, Object> response = new HashMap<>();
        response.put("produto_id", productId);
        response.put("media_sentimento", Math.round(average * 100.0) / 100.0);

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
}
