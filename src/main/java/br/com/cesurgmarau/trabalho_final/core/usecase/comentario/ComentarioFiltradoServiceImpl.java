package br.com.cesurgmarau.trabalho_final.core.usecase.comentario;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.buscaFiltrada.ComentarioFiltradoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.buscaFiltrada.ComentarioFiltradoUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioFiltradoServiceImpl implements ComentarioFiltradoUseCase {

    @Autowired
    ComentarioFiltradoRepository comentarioFiltradoRepository;

    @Override
    public List<Comentario> filtraPorProduto(int idProduto) {
        return comentarioFiltradoRepository.filtraPorProduto(idProduto);
    }

    @Override
    public List<Comentario> filtraPorUsuario(int idUsuario) {
        return comentarioFiltradoRepository.filtraPorUsuario(idUsuario);
    }

    @Override
    public List<Comentario> filtraPorSentimento(String sentimento) {
        return comentarioFiltradoRepository.filtraPorSentimento(sentimento);
    }
}
