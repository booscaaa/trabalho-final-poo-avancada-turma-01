package br.com.cesurgmarau.trabalho_final.Core.usecase;

import br.com.cesurgmarau.trabalho_final.Core.domain.contract.UseCase.ComentariosUseCase;
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


}
