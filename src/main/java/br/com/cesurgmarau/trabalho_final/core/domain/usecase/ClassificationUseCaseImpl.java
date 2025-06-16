package br.com.cesurgmarau.trabalho_final.core.domain.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ClassificationRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ClassificationUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Classification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassificationUseCaseImpl implements ClassificationUseCase {

    @Autowired
    private ClassificationRepository classificationRepository;

    @Override
    public Classification create(Classification classification) {
        return classificationRepository.create(classification);
    }

    @Override
    public Classification update(int classificationID, Classification classification) {
        return classificationRepository.update(classificationID, classification);
    }

    @Override
    public void delete(int classificationID) {
        classificationRepository.delete(classificationID);
    }

    @Override
    public Classification getByID(int classificationID) {
        return classificationRepository.getByID(classificationID);
    }

    @Override
    public List<Classification> fetch() {
        return classificationRepository.fetch();
    }
}