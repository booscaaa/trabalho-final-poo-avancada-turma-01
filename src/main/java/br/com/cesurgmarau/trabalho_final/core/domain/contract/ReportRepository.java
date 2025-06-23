package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import java.util.List;

public interface ReportRepository {
    List<Object[]> getCommentCountByFeelingId(int id);
    List<Object[]> getFeelingDataByProductId(int id);
    List<Object[]> getUserRanking();
}
