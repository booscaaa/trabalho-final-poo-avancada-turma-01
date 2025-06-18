package br.com.cesurgmarau.trabalho_final.core.usecase.comentario;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.CRUD.ComentarioCRUDRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.CRUD.ComentarioCRUDUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.produto.AvaliacaoProduto.AvaliacaoMediaRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.infra.gateway.ChatGPTGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CometarioCRUDServiceImpl implements ComentarioCRUDUseCase {

    @Autowired
    ComentarioCRUDRepository comentarioCRUDRepository;

    @Autowired
    AvaliacaoMediaRepository avaliacaoMediaRepository;

    @Autowired
    ChatGPTGateway chatGPTGateway;

    @Override
    public List<Comentario> fetch() {
        return comentarioCRUDRepository.fetch();
    }

    @Override
    public Comentario fetchById(int id) {
        return comentarioCRUDRepository.fetchById(id);
    }

    @Override
    public void createComentario(Comentario comentario, int produtoID) {

        chatGPTGateway.analisarComentario(comentario);

        avaliacaoMediaRepository.updateAvaliacaoMediaProduto(produtoID);

        comentarioCRUDRepository.createComentario(comentario, produtoID);
    }

    @Override
    public void updateComentario(Comentario comentario, int id) {
        comentarioCRUDRepository.updateComentario(comentario, id);
    }

    @Override
    public void deleteComentario(int id) {
        comentarioCRUDRepository.deleteComentario(id);
    }

}
