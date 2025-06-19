package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.controller.CompraController;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase.CompraUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase.ProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase.UsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Compra;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.ProdutoCompra;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.core.dto.request.CompraRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.CompraResponseDTO;
import br.com.cesurgmarau.trabalho_final.core.mapper.CompraMapper;
import br.com.cesurgmarau.trabalho_final.core.mapper.ProdutoCompraMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class CompraControllerImpl implements CompraController {

    @Autowired
    CompraUseCase compraUseCase;
    @Autowired
    UsuarioUseCase usuarioUseCase;
    @Autowired
    ProdutoUseCase produtoUseCase;

    @PostMapping("/compra")
    @Override
    public void createCompra(CompraRequestDTO compraRequestDTO) {
        Usuario usuario = usuarioUseCase.readUsuario(compraRequestDTO.getUsuarioId());

        List<ProdutoCompra> produtosCompra = compraRequestDTO.getProdutos().stream()
                .map(dto -> {
                    Produto produto = produtoUseCase.readProduto(dto.getProdutoId());
                    return ProdutoCompraMapper.toEntity(null, produto, dto.getQuantidade());
                })
                .collect(Collectors.toList());

        Compra compra = CompraMapper.toEntity(compraRequestDTO, usuario, produtosCompra);

        produtosCompra.forEach(pc -> pc.setCompra(compra));
        compraUseCase.createCompra(compra);
    }

    @GetMapping("/compra")
    @Override
    public List<CompraResponseDTO> readCompra() {
        return compraUseCase.readCompra().stream()
                .map(CompraMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/compra/{id}")
    @Override
    public CompraResponseDTO readCompra(Integer id) {
        Compra compra = compraUseCase.readCompra(id);
        return CompraMapper.toResponseDTO(compra);
    }

    @PutMapping("/compra/{id}")
    @Override
    public void updateCompra(Integer id, CompraRequestDTO compraRequestDTO) {
        Usuario usuario = usuarioUseCase.readUsuario(compraRequestDTO.getUsuarioId());

        List<ProdutoCompra> produtosCompra = compraRequestDTO.getProdutos().stream()
                .map(dto -> {
                    Produto produto = produtoUseCase.readProduto(dto.getProdutoId());
                    return ProdutoCompraMapper.toEntity(null, produto, dto.getQuantidade());
                })
                .collect(Collectors.toList());

        Compra compra = CompraMapper.toEntity(compraRequestDTO, usuario, produtosCompra);
        compra.setId(id);

        produtosCompra.forEach(pc -> pc.setCompra(compra));

        compraUseCase.updateCompra(id, compra);
    }

    @DeleteMapping("/compra/{id}")
    @Override
    public void deleteCompra(Integer id) {
        compraUseCase.deleteCompra(id);
    }
}
