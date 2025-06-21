package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioContracts.ComentarioGateway;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.DeepSeekRequest;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.DeepSeekResponse;
import br.com.cesurgmarau.trabalho_final.infra.gateway.DeepSeekApiGateway;
import org.springframework.stereotype.Service;

@Service
public class DeepSeekUseCaseImpl implements ComentarioGateway {
    private final DeepSeekApiGateway client;

    public DeepSeekUseCaseImpl(DeepSeekApiGateway client){
        this.client = client;
    }

    @Override
    public DeepSeekResponse resposta(DeepSeekRequest request) throws Exception {
        return client.enviarRequisicao(request);
    }
}
