package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioContracts.ComentarioGateway;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.DeepSeekRequest;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.DeepSeekResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ia")
public class DeepSeekApiController {

    private final ComentarioGateway comentarioGateway;

    public DeepSeekApiController(ComentarioGateway comentarioGateway){
        this.comentarioGateway = comentarioGateway;
    }

    @PostMapping("/resposta")
    public ResponseEntity<DeepSeekResponse> resposta(@RequestBody DeepSeekRequest request) {
        try {
            var resp = comentarioGateway.resposta(request);
            return ResponseEntity.ok(resp);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar resposta: " + e.getMessage());
        }
    }
}
