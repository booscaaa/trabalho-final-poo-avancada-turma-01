package br.com.cesurgmarau.trabalho_final.core.domain.contract.controller;

import br.com.cesurgmarau.trabalho_final.core.dto.request.ComentarioRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.ComentarioResponseDTO;

import java.util.List;

public interface ComentarioController {
    public void createComentario(ComentarioRequestDTO comentarioRequestDTO);
    public List<ComentarioResponseDTO> readComentario();
    public ComentarioResponseDTO readComentario(int id);
    public void updateComentario(int id, ComentarioRequestDTO comentarioRequestDTO);
    public void deleteComentario(int id);
}
