package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.RelatorioContracts.RelatorioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.MediaProdutoDto;
import br.com.cesurgmarau.trabalho_final.core.domain.dto.UsuarioAtivoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RelatorioController {

    @Autowired
    private RelatorioUseCase relatorioUseCase;

    public RelatorioController(RelatorioUseCase relatorioUseCase) {
        this.relatorioUseCase = relatorioUseCase;
    }

    @GetMapping("/relatorios/sentimentos")
    public ResponseEntity<?> relatorioSentimentos(){
        try {
            return ResponseEntity.ok(relatorioUseCase.relatorioSentimentos());
        } catch (Exception e){
            throw new RuntimeException("Erro ao retornar relatório por sentimetnos: " + e.getMessage());
        }
    }

    @GetMapping("relatorios/produtos")
    public ResponseEntity<?> mediaProdutos(){
        try {
            List<MediaProdutoDto> mediaProdutos = relatorioUseCase.mediaProdutos();
            return ResponseEntity.ok(mediaProdutos);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar relatório da média dos produtos: " + e.getMessage());
        }
    }

    @GetMapping("relatorios/usuarios")
    public ResponseEntity<?> usuariosMaisAtivo(){
        try {
            List<UsuarioAtivoDto> usuariosAtivos = relatorioUseCase.usuarioMaisAtivo();
            return ResponseEntity.ok(usuariosAtivos);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao listar relatório de usuários mais ativos: " + e.getMessage());
        }
    }

    @GetMapping("relatorios/mais-ativo")
    public ResponseEntity<?> usuarioMaisAtivo(){
        var ranking = relatorioUseCase.usuarioMaisAtivo();

        if (!ranking.isEmpty()){
            return ResponseEntity.ok(ranking.get(0));
        } else {
            throw new NullPointerException("Lista vazia...");
        }
    }
}
