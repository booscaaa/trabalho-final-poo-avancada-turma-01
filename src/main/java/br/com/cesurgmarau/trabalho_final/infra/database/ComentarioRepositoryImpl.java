package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.TipoSentimento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComentarioRepositoryImpl implements ComentarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Comentario salvar(Comentario comentario) {
        if (comentario.getId() == null) {
            entityManager.persist(comentario);
            return comentario;
        } else {
            return entityManager.merge(comentario);
        }
    }

    @Override
    public Optional<Comentario> buscarPorId(Long id) {
        return Optional.ofNullable(entityManager.find(Comentario.class, id));
    }

    @Override
    public List<Comentario> buscarTodos() {
        return entityManager.createQuery("SELECT c FROM Comentario c", Comentario.class)
                .getResultList();
    }

    @Override
    public List<Comentario> buscarPorProdutoId(Long produtoId) {
        return entityManager.createQuery("SELECT c FROM Comentario c WHERE c.produto.id = :produtoId", Comentario.class)
                .setParameter("produtoId", produtoId)
                .getResultList();
    }

    @Override
    public List<Comentario> buscarPorUsuarioId(Long usuarioId) {
        return entityManager.createQuery("SELECT c FROM Comentario c WHERE c.usuario.id = :usuarioId", Comentario.class)
                .setParameter("usuarioId", usuarioId)
                .getResultList();
    }

    @Override
    public List<Comentario> buscarPorSentimento(TipoSentimento sentimento) {
        return entityManager.createQuery("SELECT c FROM Comentario c WHERE c.sentimento = :sentimento", Comentario.class)
                .setParameter("sentimento", sentimento)
                .getResultList();
    }

    @Override
    @Transactional
    public void deletar(Long id) {
        Comentario comentario = entityManager.find(Comentario.class, id);
        if (comentario != null) {
            entityManager.remove(comentario);
        }
    }
}

