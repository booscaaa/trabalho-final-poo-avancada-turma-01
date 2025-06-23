package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import java.util.List;

public interface ReportRepository {
    List<Object[]> getCommentCountByFeelingId(int id);
    List<Number> getFeelingValuesByProductId(int id);
    List<Object[]> getUserRanking();
}
