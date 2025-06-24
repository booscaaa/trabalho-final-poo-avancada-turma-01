package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.TipoSentimento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ComentarioRepositoryImpl implements ComentarioRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
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
    public List<Comentario> listarTodos() {
        String jpql = "SELECT c FROM Comentario c";
        return entityManager.createQuery(jpql, Comentario.class).getResultList();
    }

    @Override
    public List<Comentario> buscarPorProdutoId(Long produtoId) {
        String jpql = "SELECT c FROM Comentario c WHERE c.produto.id = :produtoId";
        TypedQuery<Comentario> query = entityManager.createQuery(jpql, Comentario.class);
        query.setParameter("produtoId", produtoId);
        return query.getResultList();
    }

    @Override
    public List<Comentario> buscarPorUsuarioId(Long usuarioId) {
        String jpql = "SELECT c FROM Comentario c WHERE c.usuario.id = :usuarioId";
        TypedQuery<Comentario> query = entityManager.createQuery(jpql, Comentario.class);
        query.setParameter("usuarioId", usuarioId);
        return query.getResultList();
    }

    @Override
    public List<Comentario> buscarPorSentimento(TipoSentimento sentimento) {
        String jpql = "SELECT c FROM Comentario c WHERE c.sentimento = :sentimento";
        TypedQuery<Comentario> query = entityManager.createQuery(jpql, Comentario.class);
        query.setParameter("sentimento", sentimento);
        return query.getResultList();
    }
}


