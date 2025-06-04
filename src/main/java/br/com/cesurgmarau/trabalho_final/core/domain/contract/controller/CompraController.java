package br.com.cesurgmarau.trabalho_final.core.domain.contract.controller;

import br.com.cesurgmarau.trabalho_final.core.dto.request.CompraRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.CompraResponseDTO;

import java.util.List;

public interface CompraController {
    public void createCompra(CompraRequestDTO compraRequestDTO);
    public List<CompraResponseDTO> readCompra();
    public CompraResponseDTO readCompra(int id);
    public void updateCompra(int id, CompraRequestDTO compraRequestDTO);
    public void deleteCompra(int id);
}
