package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import java.util.List;
import java.util.Map;

public interface ReportUseCase {
    Map<String, Object> getCommentCountByFeelingId(int id);
    Map<String, Object> getAverageFeelingByProductId(int id);
    List<Map<String, Object>> getUserRanking();
}
