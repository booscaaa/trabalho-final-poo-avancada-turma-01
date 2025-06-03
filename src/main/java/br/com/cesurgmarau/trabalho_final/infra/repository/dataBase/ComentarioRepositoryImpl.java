package br.com.cesurgmarau.trabalho_final.infra.repository.dataBase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import br.com.cesurgmarau.trabalho_final.core.dto.ComentarioDTO;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComentarioRepositoryImpl implements ComentarioRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void adicionarComentario(Comentario comentario) {
        var query = """
                INSERT INTO comentario (usuario_id, produto_id, comentario, sentimento_id)
                VALUES (:usuario_id, :produto_id, :comentario, :sentimento_id)
                """;
        entityManager.createNativeQuery(query)
                .setParameter("usuario_id", comentario.getUsuarioId())
                .setParameter("produto_id", comentario.getProdutoId())
                .setParameter("comentario", comentario.getComentario())
                .setParameter("sentimento_id", comentario.getSentimentoId())
                .executeUpdate();
    }

    @Override
    public ComentarioDTO listarComentarioPorId(int id) {
        var query = """
                SELECT comentario.*, usuario.nome FROM comentario
                INNER JOIN usuario ON comentario.usuario_id = usuario.id
                WHERE comentario.id = :id;
                """;
        return (ComentarioDTO) entityManager
                .createNativeQuery(query, "ComentarioDTOMapping")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<ComentarioDTO> listarComentario() {
        var query = """
                SELECT comentario.*, usuario.nome FROM comentario
                INNER JOIN usuario ON comentario.usuario_id = usuario.id;
                """;
        return entityManager.createNativeQuery(query, "ComentarioDTOMapping")
                .getResultList();
    }

    @Override
    public List<ComentarioDTO> listarComentarioPorProduto(int produto_id) {
        var query = """
                SELECT comentario.*, usuario.nome FROM comentario
                INNER JOIN usuario ON comentario.usuario_id = usuario.id
                WHERE comentario.produto_id = :produto_id;
                """;
        return entityManager.createNativeQuery(query, "ComentarioDTOMapping")
                .setParameter("produto_id", produto_id)
                .getResultList();
    }

    @Override
    public List<ComentarioDTO> listarUsuarioComComentario(int usuario_id) {
        var query = """
                SELECT comentario.*, usuario.nome FROM comentario
                INNER JOIN usuario ON comentario.usuario_id = usuario.id
                WHERE comentario.usuario_id = :usuario_id;
                """;
        return entityManager.createNativeQuery(query, "ComentarioDTOMapping")
                .setParameter("usuario_id", usuario_id)
                .getResultList();
    }

    @Override
    public List<ComentarioDTO> listarComentarioPorSentimento(int sentimento_id) {
        var query = """
                SELECT comentario.*, usuario.nome FROM comentario
                INNER JOIN usuario ON comentario.usuario_id = usuario.id
                WHERE comentario.sentimento_id = :sentimento_id;
                """;
        return entityManager.createNativeQuery(query, "ComentarioDTOMapping")
                .setParameter("sentimento_id", sentimento_id)
                .getResultList();
    }


}
