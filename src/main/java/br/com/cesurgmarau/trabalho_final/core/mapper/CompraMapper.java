package br.com.cesurgmarau.trabalho_final.core.mapper;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Compra;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.ProdutoCompra;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Usuario;
import br.com.cesurgmarau.trabalho_final.core.dto.request.CompraRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.CompraResponseDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.ProdutoCompraResponseDTO;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class CompraMapper {
    public static Compra toEntity(CompraRequestDTO dto, Usuario usuario, List<ProdutoCompra> produtosCompra) {
        return new Compra(
                0,
                LocalDateTime.now(),
                dto.getValorTotal(),
                usuario,
                produtosCompra
        );
    }

    public static CompraResponseDTO toResponseDTO(Compra compra) {
        List<ProdutoCompraResponseDTO> produtosDto = compra.getProdutos().stream()
                .map(pc -> new ProdutoCompraResponseDTO(
                        pc.getProduto().getId(),
                        pc.getProduto().getNome(),
                        pc.getQuantidade()
                ))
                .collect(Collectors.toList());

        return new CompraResponseDTO(
                compra.getId(),
                compra.getData(),
                compra.getValorTotal(),
                compra.getUsuario().getId(),
                compra.getUsuario().getNome(),
                produtosDto
        );
    }
}
