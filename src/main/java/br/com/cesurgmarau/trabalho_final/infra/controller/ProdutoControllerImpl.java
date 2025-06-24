package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.controller.ProdutoController;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase.ProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.dto.request.ProdutoRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.ProdutoResponseDTO;
import br.com.cesurgmarau.trabalho_final.core.mapper.ProdutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProdutoControllerImpl implements ProdutoController {

    @Autowired
    ProdutoUseCase produtoUseCase;

    @PostMapping("/produto")
    @Override
    public ResponseEntity<Void> createProduto(@RequestBody ProdutoRequestDTO produtoRequestDTO) {
        produtoUseCase.createProduto(ProdutoMapper.toEntity(produtoRequestDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/produto")
    @Override
    public ResponseEntity<List<ProdutoResponseDTO>> readProduto() {
        List<ProdutoResponseDTO> produtosDTO = produtoUseCase.readProduto().stream().map(ProdutoMapper::toResponseDTO).collect(Collectors.toList());

        if (produtosDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtosDTO);
    }

    @GetMapping("/produto/{id}")
    @Override
    public ResponseEntity<ProdutoResponseDTO> readProduto(@PathVariable Integer id) {
        ProdutoResponseDTO produtoDTO = ProdutoMapper.toResponseDTO(produtoUseCase.readProduto(id));

        if (produtoDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(produtoDTO);
    }

    @PutMapping("/produto/{id}")
    @Override
    public ResponseEntity<Void> updateProduto(@PathVariable Integer id, @RequestBody ProdutoRequestDTO produtoRequestDTO) {
        produtoUseCase.updateProduto(id, ProdutoMapper.toEntity(produtoRequestDTO));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/produto/{id}")
    @Override
    public ResponseEntity<Void> deleteProduto(@PathVariable Integer id) {
        produtoUseCase.deleteProduto(id);
        return ResponseEntity.noContent().build();
    }
}
