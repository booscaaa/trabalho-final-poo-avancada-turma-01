package br.com.cesurgmarau.trabalho_final.core.mapper;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.enums.Unidade;
import br.com.cesurgmarau.trabalho_final.core.dto.request.ProdutoRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.ProdutoResponseDTO;

public class ProdutoMapper {

    public static Produto toEntity(ProdutoRequestDTO dto) {
        return new Produto(
                0,
                dto.getNome(),
                dto.getValorUnitario(),
                Unidade.values()[dto.getUnidade()],
                dto.getDescricao(),
                dto.getQuantidade(),
                null
        );
    }

    public static ProdutoResponseDTO toResponseDTO(Produto produto) {
        return new ProdutoResponseDTO(
        produto.getId(),
        produto.getNome(),
        produto.getValorUnitario(),
        produto.getUnidade().ordinal(),
        produto.getDescricao(),
        produto.getQuantidade(),
        produto.getData()
        );
    }
}
