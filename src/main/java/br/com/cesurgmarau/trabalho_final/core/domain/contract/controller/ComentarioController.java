package br.com.cesurgmarau.trabalho_final.core.domain.contract.controller;

import br.com.cesurgmarau.trabalho_final.core.dto.request.ComentarioRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.ComentarioResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ComentarioController {
    public ResponseEntity<Void> createComentario(ComentarioRequestDTO comentarioRequestDTO);
    public ResponseEntity<List<ComentarioResponseDTO>> readComentario();
    public ResponseEntity<ComentarioResponseDTO> readComentario(Integer id);
    public ResponseEntity<Void> updateComentario(Integer id, ComentarioRequestDTO comentarioRequestDTO);
    public ResponseEntity<Void> deleteComentario(Integer id);
}
