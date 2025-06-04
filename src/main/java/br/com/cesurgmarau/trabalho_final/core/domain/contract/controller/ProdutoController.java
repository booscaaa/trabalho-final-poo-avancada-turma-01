package br.com.cesurgmarau.trabalho_final.core.domain.contract.controller;

import br.com.cesurgmarau.trabalho_final.core.dto.request.ProdutoRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.ProdutoResponseDTO;

import java.util.List;

public interface ProdutoController {
    public void createProduto(ProdutoRequestDTO produtoRequestDTO);
    public List<ProdutoResponseDTO> readProduto();
    public ProdutoResponseDTO readProduto(int id);
    public void updateProduto(int id, ProdutoRequestDTO produtoRequestDTO);
    public void deleteProduto(int id);
}
