package br.com.cesurgmarau.trabalho_final.infra.repository.dataBase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ComentarioRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
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
    public Comentario listarComentarioPorId(int id) {
        return null;
    }

    @Override
    public List<Comentario> listarComentario() {
        return List.of();
    }
}
