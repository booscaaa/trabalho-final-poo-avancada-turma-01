package br.com.cesurgmarau.trabalho_final.core.usecase;

import br.com.cesurgmarau.trabalho_final.core.DTO.RelatorioComentariosDTO;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.UseCase.ComentariosUseCase;
import br.com.cesurgmarau.trabalho_final.Core.domain.entity.Comentarios;
import br.com.cesurgmarau.trabalho_final.infra.repository.ComentariosRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ComentariosServiceImpl implements ComentariosUseCase {
    @Autowired
    ComentariosRepositoryImpl comentariosRepository;

    @Override
    public List<Comentarios> fetch() {
        return comentariosRepository.fetch();
    }

    @Override
    public Comentarios fetchById(int id) {
        return comentariosRepository.fetchById(id);
    }

    @Override
    public void createComentario(Comentarios comentario) {

        String sentimento = "neutro";
        String texto = comentario.getComentario();

        if (texto != null) {
            if (texto.contains("bom") || texto.contains("BOM")
                    || texto.contains("ótimo") || texto.contains("ÓTIMO")
                    || texto.contains("excelente") || texto.contains("EXCELENTE")
                    || texto.contains("maravilhoso") || texto.contains("MARAVILHOSO")
                    || texto.contains("fantástico") || texto.contains("FANTÁSTICO")
                    || texto.contains("incrível") || texto.contains("INCRÍVEL")
                    || texto.contains("positivo") || texto.contains("POSITIVO")
                    || texto.contains("satisfeito") || texto.contains("SATISFEITO")) {
                sentimento = "positivo";
            } else if (texto.contains("ruim") || texto.contains("RUIM")
                    || texto.contains("péssimo") || texto.contains("PÉSSIMO")
                    || texto.contains("horrível") || texto.contains("HORRÍVEL")
                    || texto.contains("com defeito") || texto.contains("COM DEFEITO")
                    || texto.contains("problema") || texto.contains("PROBLEMA")
                    || texto.contains("insuportável") || texto.contains("INSUPORTÁVEL")
                    || texto.contains("reclamação") || texto.contains("RECLAMAÇÃO")
                    || texto.contains("pior") || texto.contains("PIOR")
                    || texto.contains("não recomendo") || texto.contains("NÃO RECOMENDO")
                    || texto.contains("decepcionante") || texto.contains("DECEPCIONANTE")) {
                sentimento = "negativo";
            }
        }
        comentario.setSentimento(sentimento);
        comentariosRepository.createComentario(comentario);

    }

    @Override
    public void updateComentario(Comentarios comentario, int id) {
        comentariosRepository.updateComentario(comentario, id);
    }

    @Override
    public void deleteComentario(int id) {
        comentariosRepository.deleteComentario(id);
    }
    @Override
    public RelatorioComentariosDTO gerarRelatorio() {
        RelatorioComentariosDTO dto = new RelatorioComentariosDTO();

        dto.setTotalPorSentimento(comentariosRepository.totalComentariosPorSentimento());
        dto.setMediaSentimentoPorProduto(comentariosRepository.mediaSentimentoPorProduto());
        dto.setUsuariosMaisAtivos(comentariosRepository.rankingUsuariosMaisAtivos());

        return dto;
    }
    @Override
    public List<Comentarios> buscarPorSentimento(String sentimento) {
        return comentariosRepository.buscarPorSentimento(sentimento);
    }



}


