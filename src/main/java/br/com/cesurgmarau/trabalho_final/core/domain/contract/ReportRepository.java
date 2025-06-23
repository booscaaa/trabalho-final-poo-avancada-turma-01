package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import java.util.List;
import java.util.Map;

public interface ReportRepository {
    List<Object[]> getCommentCountByFeelingId(int id);
    List<Object[]> getFeelingDataByProductId(int id);
    List<Object[]> getUserRanking();
    Long countUsers();
    Long countProducts();
    Long countComments();
    Double averageFeeling();
    Object[] topProduct();
    Object[] topUser();
}
