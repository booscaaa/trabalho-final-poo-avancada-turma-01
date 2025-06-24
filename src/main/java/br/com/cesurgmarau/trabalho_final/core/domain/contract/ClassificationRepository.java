package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Classification;

import java.util.List;

public interface ClassificationRepository {
    public Classification create(Classification classification);
    public Classification update(int classificationID, Classification classification);
    public void delete(int classificationID);
    public Classification getByID(int classificationID);
    public Classification getByName(String name);
    public List<Classification> fetch();
}
