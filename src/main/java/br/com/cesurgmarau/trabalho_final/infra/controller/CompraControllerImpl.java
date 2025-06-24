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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> createCompra(@RequestBody CompraRequestDTO compraRequestDTO) {
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

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/compra")
    @Override
    public ResponseEntity<List<CompraResponseDTO>> readCompra() {
        List<CompraResponseDTO> comprasDTO = compraUseCase.readCompra().stream()
                .map(CompraMapper::toResponseDTO)
                .collect(Collectors.toList());

        if (comprasDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comprasDTO);
    }

    @GetMapping("/compra/{id}")
    @Override
    public ResponseEntity<CompraResponseDTO> readCompra(@PathVariable Integer id) {
        CompraResponseDTO compraDTO = CompraMapper.toResponseDTO(compraUseCase.readCompra(id));

        if (compraDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(compraDTO);
    }

    @PutMapping("/compra/{id}")
    @Override
    public ResponseEntity<Void> updateCompra(@PathVariable Integer id, @RequestBody CompraRequestDTO compraRequestDTO) {
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
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/compra/{id}")
    @Override
    public ResponseEntity<Void> deleteCompra(@PathVariable Integer id) {
        compraUseCase.deleteCompra(id);
        return ResponseEntity.noContent().build();
    }
}
