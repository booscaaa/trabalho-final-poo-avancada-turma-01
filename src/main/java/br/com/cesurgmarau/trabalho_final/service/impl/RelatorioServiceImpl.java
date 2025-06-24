package br.com.cesurgmarau.trabalho_final.service.impl;

import br.com.cesurgmarau.trabalho_final.dto.RelatorioProdutoDTO;
import br.com.cesurgmarau.trabalho_final.dto.RelatorioSentimentoDTO;
import br.com.cesurgmarau.trabalho_final.dto.RelatorioUsuarioDTO;
import br.com.cesurgmarau.trabalho_final.repository.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.service.interfaces.RelatorioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RelatorioServiceImpl implements RelatorioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Override
    public List<RelatorioSentimentoDTO> totalComentariosPorSentimento() {
        List<Object[]> resultados = comentarioRepository.contarComentariosPorSentimento();
        List<RelatorioSentimentoDTO> relatorios = new ArrayList<>();

        for (Object[] row : resultados) {
            RelatorioSentimentoDTO dto = new RelatorioSentimentoDTO();
            dto.setSentimento((String) row[0]);
            dto.setTotal((Long) row[1]);
            relatorios.add(dto);
        }
        return relatorios;
    }

    @Override
    public List<RelatorioProdutoDTO> mediaSentimentoPorProduto() {
        List<Object[]> resultados = comentarioRepository.mediaSentimentoPorProduto();
        List<RelatorioProdutoDTO> relatorios = new ArrayList<>();

        for (Object[] row : resultados) {
            RelatorioProdutoDTO dto = new RelatorioProdutoDTO();
            dto.setProdutoId((Long) row[0]);
            dto.setNomeProduto((String) row[1]);
            dto.setMediaSentimento((Double) row[2]);
            relatorios.add(dto);
        }
        return relatorios;
    }

    @Override
    public List<RelatorioUsuarioDTO> rankingUsuariosMaisAtivos() {
        List<Object[]> resultados = comentarioRepository.rankingUsuariosMaisAtivos();
        List<RelatorioUsuarioDTO> relatorios = new ArrayList<>();

        for (Object[] row : resultados) {
            RelatorioUsuarioDTO dto = new RelatorioUsuarioDTO();
            dto.setUsuarioId((Long) row[0]);
            dto.setNomeUsuario((String) row[1]);
            dto.setTotalComentarios((Long) row[2]);
            relatorios.add(dto);
        }
        return relatorios;
    }
}
