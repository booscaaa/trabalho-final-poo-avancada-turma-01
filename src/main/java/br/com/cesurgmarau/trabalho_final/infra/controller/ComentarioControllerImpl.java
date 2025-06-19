package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.controller.ComentarioController;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase.ComentarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase.ProdutoUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.usecase.UsuarioUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.dto.request.ComentarioRequestDTO;
import br.com.cesurgmarau.trabalho_final.core.dto.response.ComentarioResponseDTO;
import br.com.cesurgmarau.trabalho_final.core.mapper.ComentarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ComentarioControllerImpl implements ComentarioController {

    @Autowired
    private ComentarioUseCase comentarioUseCase;

    @Autowired
    private UsuarioUseCase usuarioUseCase;

    @Autowired
    private ProdutoUseCase produtoUseCase;

    @PostMapping("/comentario")
    @Override
    public void createComentario(ComentarioRequestDTO comentarioRequestDTO) {
        comentarioUseCase.createComentario(
                ComentarioMapper.toEntity(comentarioRequestDTO,
                usuarioUseCase.readUsuario(comentarioRequestDTO.getUsuarioId()),
                        produtoUseCase.readProduto(comentarioRequestDTO.getProdutoId())));

    }

    @GetMapping("/comentario")
    @Override
    public List<ComentarioResponseDTO> readComentario() {
        List<Comentario> comentariosEntity = comentarioUseCase.readComentario();
        List<ComentarioResponseDTO> comentariosDTO = new ArrayList<>();
        for (Integer i = 0; i < comentariosEntity.size(); i++) {
            comentariosDTO.add(ComentarioMapper.toResponseDTO(comentariosEntity.get(i)));
        }

        return comentariosDTO;
    }

    @GetMapping("/comentario/{id}")
    @Override
    public ComentarioResponseDTO readComentario(Integer id) {
        return ComentarioMapper.toResponseDTO(comentarioUseCase.readComentario(id));
    }

    @PutMapping("/comentario/{id}")
    @Override
    public void updateComentario(Integer id, ComentarioRequestDTO comentarioRequestDTO) {
        comentarioUseCase.updateComentario(id, ComentarioMapper.toEntity(comentarioRequestDTO,
                usuarioUseCase.readUsuario(comentarioRequestDTO.getUsuarioId()),
                produtoUseCase.readProduto(comentarioRequestDTO.getProdutoId())));
    }

    @DeleteMapping("/comentario/{id}")
    @Override
    public void deleteComentario(Integer id) {
        comentarioUseCase.deleteComentario(id);
    }
}
