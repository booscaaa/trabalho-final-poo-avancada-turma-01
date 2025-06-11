package br.com.cesurgmarau.trabalho_final.service;


import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final IAService iaService;
    public ComentarioService(ComentarioRepository comentarioRepository, IAService iaService) {
        this.comentarioRepository = comentarioRepository;
        this.iaService = iaService;
    }

    public List<Comentario> listarComentarios() {
        return comentarioRepository.listar();
    }

    public Comentario listarPorId(int id) {
        return comentarioRepository.listarPorId(id);
    }

    public void adicionarComentario(Comentario comentario) throws Exception {
        String sentimento = iaService.classificarSentimento(comentario.getTexto());
        comentario.setSentimento(sentimento);

        comentarioRepository.adicionarComentario(comentario);
    }

    public String deletarComentario(int id) {
        return comentarioRepository.deletarComentario(id);
    }

    public String atualizarComentario(int id, Comentario comentario) throws Exception {
        String sentimento = iaService.classificarSentimento(comentario.getTexto());
        comentario.setSentimento(sentimento);

        return comentarioRepository.atualizarComentario(id, comentario);
    }
}
