package br.com.cesurgmarau.trabalho_final.core.domain.contract.controller;

import br.com.cesurgmarau.trabalho_final.core.dto.request.CompraRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.CompraResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CompraController {
    public ResponseEntity<Void> createCompra(CompraRequestDTO compraRequestDTO);
    public ResponseEntity<List<CompraResponseDTO>> readCompra();
    public ResponseEntity<CompraResponseDTO> readCompra(Integer id);
    public ResponseEntity<Void> updateCompra(Integer id, CompraRequestDTO compraRequestDTO);
    public ResponseEntity<Void> deleteCompra(Integer id);
}
