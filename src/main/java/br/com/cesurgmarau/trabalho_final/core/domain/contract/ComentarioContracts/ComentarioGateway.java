package br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioContracts;

import br.com.cesurgmarau.trabalho_final.core.domain.dto.DeepSeekRequest;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.DeepSeekResponse;

public interface ComentarioGateway {
    DeepSeekResponse resposta(DeepSeekRequest request) throws Exception;
}
