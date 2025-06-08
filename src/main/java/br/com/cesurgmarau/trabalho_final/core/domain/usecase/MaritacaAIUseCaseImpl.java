package br.com.cesurgmarau.trabalho_final.core.domain.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.MaritacaAIGateway;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.MaritacaAIUseCase;
import org.springframework.beans.factory.annotation.Autowired;

public class MaritacaAIUseCaseImpl implements MaritacaAIUseCase {
    @Autowired
    MaritacaAIGateway maritacaAIGateway;

    @Override
    public String commentAssess(String comment) {
        return maritacaAIGateway.commentAssess(comment);
    }
}
