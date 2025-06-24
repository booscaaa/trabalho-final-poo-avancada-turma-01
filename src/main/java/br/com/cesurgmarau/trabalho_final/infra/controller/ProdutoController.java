package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.dto.produto.ProdutoResponseDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping
public class ProdutoController {

    private final ProdutoUseCase produtoUseCase;

    public ProdutoController(ProdutoUseCase produtoUseCase) {
        this.produtoUseCase = produtoUseCase;
    }

    private ProdutoResponseDTO produtoResponseDTO(Produto produto) {
        ProdutoResponseDTO responseDTO = new ProdutoResponseDTO();
        responseDTO.setId(produto.getId());
        responseDTO.setNomeProduto(produto.getNomeProduto());
        responseDTO.setDescricaoProduto(produto.getDescricaoProduto());
        return responseDTO;
    }

    @PostMapping("/produto")
    public ProdutoResponseDTO insert(@RequestBody Produto dto) {
        Produto produto = new Produto();
        produto.setNomeProduto(dto.getNomeProduto());
        produto.setDescricaoProduto(dto.getDescricaoProduto());
        produtoUseCase.insert(produto);
        return null;
    }

    @DeleteMapping("/produto/{id}")
    public void delete (@PathVariable int id) {
        produtoUseCase.delete(id);
    }

    @GetMapping("/produto")
    public List<ProdutoResponseDTO> fetch() {
        return produtoUseCase.fetch().stream()
                .map(this::produtoResponseDTO)
                .collect(Collectors.toList());
    }

    @PutMapping("/produto/{id}")
    public void update (@PathVariable int id, @RequestBody Produto produto) {
        produtoUseCase.update(id, produto);
    }

    @GetMapping("/produto/{id}")
    public ProdutoResponseDTO get(@PathVariable int id) {
        Produto produto = produtoUseCase.get(id);
        return produtoResponseDTO(produto);
    }
}
