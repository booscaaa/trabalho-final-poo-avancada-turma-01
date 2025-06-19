package br.com.cesurgmarau.trabalho_final.core.domain.contract.controller;

import br.com.cesurgmarau.trabalho_final.core.dto.request.ProdutoCompraRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.ProdutoCompraResponseDTO;

import java.util.List;

public interface ProdutoCompraController {
    public void createProdutoCompra(ProdutoCompraRequestDTO produtoCompraRequestDTO);
    public List<ProdutoCompraResponseDTO> readProdutoCompra();
    public ProdutoCompraResponseDTO readProdutoCompra(Integer id);
    public void updateProdutoCompra(Integer compraId, Integer produtoId, ProdutoCompraRequestDTO produtoCompraRequestDTO);
    public void deleteProdutoCompra(Integer id);
}
