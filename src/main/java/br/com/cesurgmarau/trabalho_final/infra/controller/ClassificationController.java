package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ClassificationUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Classification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClassificationController {
    @Autowired
    private ClassificationUseCase classificationUseCase;

    @PostMapping("/classification")
    public Classification create(@RequestBody Classification classification) {
        classificationUseCase.create(classification);
        return classification;
    }

    @PutMapping("/classification/{classificationID}")
    public Classification update(@PathVariable int classificationID, @RequestBody Classification classification) {
        classificationUseCase.update(classificationID, classification);
        return classification;
    }

    @DeleteMapping("/classification/{classificationID}")
    public void delete(@PathVariable int classificationID) {
        classificationUseCase.delete(classificationID);
    }

    @GetMapping("/classification/{classificationID}")
    public Classification getByID(@PathVariable int classificationID) {
        return classificationUseCase.getByID(classificationID);
    }

    @GetMapping("/classification")
    public List<Classification> fetch() {
        return classificationUseCase.fetch();
    }
}
