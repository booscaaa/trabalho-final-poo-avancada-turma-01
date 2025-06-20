package br.com.cesurgmarau.trabalho_final.infra.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class ComentarioRepositoryImpl implements br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioContracts.ComentarioRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void adicionarComentario(Comentario comentario) {
        var query = """
                    INSERT INTO comentarios (comentario, sentimento, usuario, produto, sentimento_nota) VALUES(
                        :comentario,
                        :sentimento,
                        :usuario,
                        :produto,
                        :notaSentimento
                    )
                """;
        System.out.println(comentario.getComentario());
        entityManager.createNativeQuery(query)
                .setParameter("comentario", comentario.getComentario())
                .setParameter("sentimento", comentario.getSentimento())
                .setParameter("usuario", comentario.getUsuario().getId_usuario())
                .setParameter("produto", comentario.getProduto().getId())
                .setParameter("notaSentimento", comentario.getNotaSentimento())
                .executeUpdate();
    }

    @Override
    public List<Comentario> listarComentarios() {
        var query = "SELECT * FROM comentarios";

        return (List<Comentario>) entityManager.createNativeQuery(query, Comentario.class)
                .getResultList();
    }

    @Override
    public Comentario comentarioPorId(int id) {
        var query = "SELECT * FROM comentarios WHERE id_comentario = :id";

        return (Comentario) entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Comentario> buscaPorProdutoId(int produtoId) {
        String sql = "SELECT * FROM comentarios WHERE produto = :produtoId";

        return entityManager.createNativeQuery(sql, Comentario.class)
                .setParameter("produtoId", produtoId)
                .getResultList();
    }

    @Override
    public List<Comentario> buscaPorUsuarioId(int usuarioId) {
        var query = "SELECT * FROM comentarios WHERE usuario = :usuarioId";

        return entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("usuarioId", usuarioId)
                .getResultList();

    }

    @Override
    public List<Comentario> buscaPorSentimento(String sentimento) {
        var query = """
            SELECT * FROM comentarios
            WHERE sentimento ILIKE CONCAT('%', :sentimento, '%')
        """;

        return entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("sentimento", sentimento)
                .getResultList();
    }
}
