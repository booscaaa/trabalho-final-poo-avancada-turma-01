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
                    INSERT INTO comentarios (comentario, sentimento, usuario, produto) VALUES(
                        :comentario,
                        :sentimento,
                        :usuario,
                        :produto
                    )
                """;
        System.out.println(comentario.getComentario());
        entityManager.createNativeQuery(query)
                .setParameter("comentario", comentario.getComentario())
                .setParameter("sentimento", comentario.getSentimento())
                .setParameter("usuario", comentario.getUsuario().getId_usuario())
                .setParameter("produto", comentario.getProduto().getId())
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
        return null;
    }

    @Override
    public void atualizarComentario(int id, Comentario comentario) {

    }

    @Override
    public void deletarComentario(int id) {

    }
}
