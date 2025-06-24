package br.com.cesurgmarau.trabalho_final.infra.repository.comentario;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.comentario.buscaFiltrada.ComentarioFiltradoRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Comentario;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComentarioFiltradoRepositoryImpl implements ComentarioFiltradoRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public List<Comentario> filtraPorProduto(int idProduto) {

        var query = """
                
                SELECT * FROM comentarios WHERE produto_id = :produto_id;
        
                """;

        return (List<Comentario>) entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("produto_id", idProduto)
                .getResultList();
    }

    @Override
    public List<Comentario> filtraPorUsuario(int idUsuario) {
        var query = """
                
                SELECT * FROM comentarios WHERE usuario_id = :usuario_id;
        
                """;

        return (List<Comentario>) entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("usuario_id", idUsuario)
                .getResultList();
    }

    @Override
    public List<Comentario> filtraPorSentimento(String sentimento) {

        var sentimentoFormatado = sentimento.toLowerCase();

        var query = """
                
                SELECT * FROM comentarios WHERE sentimento = :sentimento;
        
                """;

        return (List<Comentario>) entityManager.createNativeQuery(query, Comentario.class)
                .setParameter("sentimento", sentimentoFormatado)
                .getResultList();
    }
}