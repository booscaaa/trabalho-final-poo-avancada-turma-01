package br.com.cesurgmarau.trabalho_final.infra.repository.produto;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.produto.AvaliacaoProduto.AvaliacaoMediaRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class ProdutoAvaliacaoRepositoryImpl implements AvaliacaoMediaRepository {

    @Autowired
    EntityManager entityManager;

    @Override
    public BigDecimal getAvaliacaoMediaProduto(int produtoID) {
        var query = """
                
                SELECT ROUND(AVG(avaliacao), 2) AS avaliacaoMedia\s
                FROM comentarios WHERE produto_id = :produto_id;
                               
                
                """;

        return (BigDecimal) entityManager.createNativeQuery(query)
                .setParameter("produto_id", produtoID)
                .getSingleResult();


    }

    @Transactional
    @Override
    public void updateAvaliacaoMediaProduto(int produtoID) {

        var avaliacaoMedia = getAvaliacaoMediaProduto(produtoID);

        var query = """
                
                UPDATE produtos SET
                avaliacao_produto = :avaliacao_produto
                WHERE id = :id
                
                """;

        entityManager.createNativeQuery(query, Produto.class)
                .setParameter("avaliacao_produto", avaliacaoMedia)
                .setParameter("id", produtoID)
                .executeUpdate();

    }
}
