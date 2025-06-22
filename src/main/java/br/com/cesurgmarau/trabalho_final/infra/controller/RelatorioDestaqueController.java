package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.RelatorioDestaqueUsecase;
import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoDestaqueResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.UsuarioDestaqueResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destaques")
public class RelatorioDestaqueController {

    private final RelatorioDestaqueUsecase usecase;

    public RelatorioDestaqueController(RelatorioDestaqueUsecase usecase) {
        this.usecase = usecase;
    }

    @GetMapping("/usuarios")
    public ResponseEntity<List<UsuarioDestaqueResponse>> usuariosDestaque() {
        return ResponseEntity.ok(usecase.listarUsuariosEmDestaque());
    }

    @GetMapping("/produtos")
    public ResponseEntity<List<ProdutoDestaqueResponse>> produtosDestaque() {
        return ResponseEntity.ok(usecase.listarProdutosEmDestaque());
    }
}
