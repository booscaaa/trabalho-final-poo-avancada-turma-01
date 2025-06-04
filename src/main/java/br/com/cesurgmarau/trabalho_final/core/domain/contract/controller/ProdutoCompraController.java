package br.com.cesurgmarau.trabalho_final.core.domain.contract.controller;

import br.com.cesurgmarau.trabalho_final.core.dto.request.ProdutoCompraRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.ProdutoCompraResponseDTO;

import java.util.List;

public interface ProdutoCompraController {
    public void createProdutoCompra(ProdutoCompraRequestDTO produtoCompraRequestDTO);
    public List<ProdutoCompraResponseDTO> readProdutoCompra();
    public ProdutoCompraResponseDTO readProdutoCompra(int id);
    public void updateProdutoCompra(int id, ProdutoCompraRequestDTO produtoCompraRequestDTO);
    public void deleteProdutoCompra(int id);
}
