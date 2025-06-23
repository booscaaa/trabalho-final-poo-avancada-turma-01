package br.com.cesurgmarau.trabalho_final.core.domain.contract.controller;

import br.com.cesurgmarau.trabalho_final.core.dto.request.ProdutoRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.ProdutoResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProdutoController {
    public ResponseEntity<Void> createProduto(ProdutoRequestDTO produtoRequestDTO);
    public ResponseEntity<List<ProdutoResponseDTO>> readProduto();
    public ResponseEntity<ProdutoResponseDTO> readProduto(Integer id);
    public ResponseEntity<Void> updateProduto(Integer id, ProdutoRequestDTO produtoRequestDTO);
    public ResponseEntity<Void> deleteProduto(Integer id);
}
