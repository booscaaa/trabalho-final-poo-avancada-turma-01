package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.RelatorioDestaqueUsecase;
import br.com.cesurgmarau.trabalho_final.core.dto.ProdutoDestaqueResponse;
import br.com.cesurgmarau.trabalho_final.core.dto.UsuarioDestaqueResponse;
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
    public List<UsuarioDestaqueResponse> usuariosDestaque() {
        return usecase.listarUsuariosEmDestaque();
    }

    @GetMapping("/produtos")
    public List<ProdutoDestaqueResponse> produtosDestaque() {
        return usecase.listarProdutosEmDestaque();
    }
}
