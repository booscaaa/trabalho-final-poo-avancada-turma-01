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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Void> createComentario(@RequestBody ComentarioRequestDTO comentarioRequestDTO) {
        comentarioUseCase.createComentario(
                ComentarioMapper.toEntity(comentarioRequestDTO,
                usuarioUseCase.readUsuario(comentarioRequestDTO.getUsuarioId()),
                        produtoUseCase.readProduto(comentarioRequestDTO.getProdutoId())));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/comentario")
    @Override
    public ResponseEntity<List<ComentarioResponseDTO>> readComentario() {
        List<Comentario> comentariosEntity = comentarioUseCase.readComentario();
        List<ComentarioResponseDTO> comentariosDTO = new ArrayList<>();
        for (Integer i = 0; i < comentariosEntity.size(); i++) {
            comentariosDTO.add(ComentarioMapper.toResponseDTO(comentariosEntity.get(i)));
        }

        if (comentariosDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comentariosDTO);
    }

    @GetMapping("/comentario/{id}")
    @Override
    public ResponseEntity<ComentarioResponseDTO> readComentario(@PathVariable Integer id) {
        ComentarioResponseDTO comentarioDTO = ComentarioMapper.toResponseDTO(comentarioUseCase.readComentario(id));

        if (comentarioDTO == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(comentarioDTO);
    }

    @PutMapping("/comentario/{id}")
    @Override
    public ResponseEntity<Void> updateComentario(@PathVariable Integer id, @RequestBody ComentarioRequestDTO comentarioRequestDTO) {
        comentarioUseCase.updateComentario(id, ComentarioMapper.toEntity(comentarioRequestDTO,
                usuarioUseCase.readUsuario(comentarioRequestDTO.getUsuarioId()),
                produtoUseCase.readProduto(comentarioRequestDTO.getProdutoId())));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/comentario/{id}")
    @Override
    public ResponseEntity<Void> deleteComentario(@PathVariable Integer id) {
        comentarioUseCase.deleteComentario(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping(params = "produtoId")
    public ResponseEntity<List<ComentarioResponseDTO>> readByProdutoId(@RequestParam Integer produtoId) {
        List<Comentario> comentariosEntity = comentarioUseCase.readByProdutoId(produtoId);
        List<ComentarioResponseDTO> comentariosDTO = new ArrayList<>();
        for (Comentario comentario : comentariosEntity) {
            comentariosDTO.add(ComentarioMapper.toResponseDTO(comentario));
        }

        return ResponseEntity.ok(comentariosDTO);
    }

    @GetMapping(params = "usuarioId")
    public ResponseEntity<List<ComentarioResponseDTO>> readByUsuarioId(@RequestParam Integer usuarioId) {
        List<Comentario> comentariosEntity = comentarioUseCase.readByUsuarioId(usuarioId);
        List<ComentarioResponseDTO> comentariosDTO = new ArrayList<>();
        for (Comentario comentario : comentariosEntity) {
            comentariosDTO.add(ComentarioMapper.toResponseDTO(comentario));
        }

        return ResponseEntity.ok(comentariosDTO);
    }

    @PostMapping("/comentario/avaliar")
    public ResponseEntity<String> avaliarComentarios() {
        int total = comentarioUseCase.avaliarComentariosPendentes();
        return ResponseEntity.ok("Total de comentários avaliados: " + total);
    }

}
