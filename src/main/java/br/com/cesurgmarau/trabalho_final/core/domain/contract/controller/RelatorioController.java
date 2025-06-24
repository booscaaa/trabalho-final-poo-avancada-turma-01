package br.com.cesurgmarau.trabalho_final.core.domain.contract.controller;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface RelatorioController {
    public ResponseEntity<Map<Integer, Long>> totalPorSentimento();
    public ResponseEntity<Map<Integer, Double>> mediaSentimentoPorProduto();
    public ResponseEntity<List<Map<String, Object>>> rankingUsuariosMaisAtivos();
}
