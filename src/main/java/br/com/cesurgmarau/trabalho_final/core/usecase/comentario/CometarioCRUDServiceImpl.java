package br.com.cesurgmarau.trabalho_final.core.usecase.comentario;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.CRUD.ComentarioCRUDUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.infra.repository.comentario.ComentarioCRUDRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CometarioCRUDServiceImpl implements ComentarioCRUDUseCase {

    @Autowired
    ComentarioCRUDRepositoryImpl comentarioCRUDRepository;

    @Override
    public List<Comentario> fetch() {
        return comentarioCRUDRepository.fetch();
    }

    @Override
    public Comentario fetchById(int id) {
        return comentarioCRUDRepository.fetchById(id);
    }

    @Override
    public void createComentario(Comentario comentario) {
        comentarioCRUDRepository.createComentario(comentario);
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
