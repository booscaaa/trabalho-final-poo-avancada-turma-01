package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.controller.ProdutoController;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase.ProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.dto.request.ProdutoRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.ProdutoResponseDTO;
import br.com.cesurgmarau.trabalho_final.core.mapper.ProdutoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ProdutoControllerImpl implements ProdutoController {

    @Autowired
    ProdutoUseCase produtoUseCase;

    @PostMapping("/produto")
    @Override
    public void createProduto(ProdutoRequestDTO produtoRequestDTO) {
        produtoUseCase.createProduto(ProdutoMapper.toEntity(produtoRequestDTO));
    }

    @GetMapping("/produto")
    @Override
    public List<ProdutoResponseDTO> readProduto() {
        return produtoUseCase.readProduto().stream().map(ProdutoMapper::toResponseDTO).collect(Collectors.toList());
    }

    @GetMapping("/produto/{id}")
    @Override
    public ProdutoResponseDTO readProduto(Integer id) {
        return ProdutoMapper.toResponseDTO(produtoUseCase.readProduto(id));
    }

    @PutMapping("/produto/{id}")
    @Override
    public void updateProduto(Integer id, ProdutoRequestDTO produtoRequestDTO) {
        produtoUseCase.updateProduto(id, ProdutoMapper.toEntity(produtoRequestDTO));
    }

    @DeleteMapping("/produto/{id}")
    @Override
    public void deleteProduto(Integer id) {
        produtoUseCase.deleteProduto(id);
    }
}
