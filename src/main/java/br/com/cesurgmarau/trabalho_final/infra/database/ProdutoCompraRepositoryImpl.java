package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.repository.ProdutoCompraRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.ProdutoCompra;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoCompraRepositoryImpl implements ProdutoCompraRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void createProdutoCompra(ProdutoCompra produtoCompra) {
        String query = "INSERT INTO produto_compra (compra_id, produto_id, quantidade) VALUES (:compra_id, :produto_id, :quantidade)";

        entityManager.createNativeQuery(query)
                .setParameter("compra_id", produtoCompra.getCompra().getId())
                .setParameter("produto_id", produtoCompra.getProduto().getId())
                .setParameter("quantidade", produtoCompra.getQuantidade())
                .executeUpdate();
    }

    @Override
    public List<ProdutoCompra> readProdutoCompra() {
        String query = "SELECT * FROM produto_compra";

        return entityManager.createNativeQuery(query, ProdutoCompra.class)
                .getResultList();
    }

    @Override
    public ProdutoCompra readProdutoCompra(Integer compraId, Integer produtoId) {
        String query = "SELECT * FROM produto_usuario WHERE (compra_id = :compra_id AND produto_id = :produto_id)";

        return (ProdutoCompra) entityManager.createNativeQuery(query, ProdutoCompra.class)
                .setParameter("compra_id", compraId)
                .setParameter("produto_id", produtoId)
                .getSingleResult();
    }

    @Transactional
    @Override
    public void updateProdutoCompra(Integer compraId, Integer produtoId, ProdutoCompra produtoCompra) {
        String query = "UPDATE produto_usuario SET (compra_id, produto_id, quantidade) = (:compra_id, :produto_id, :quantidade) WHERE (compra_id = :compra_id AND produto_id = :produto_id)";

        entityManager.createNativeQuery(query)
                .setParameter("compra_id", compraId)
                .setParameter("produto_id", produtoId)
                .setParameter("quantidade", produtoCompra.getQuantidade())
                .executeUpdate();
    }

    @Transactional
    @Override
    public void deleteProdutoCompra(Integer compraId, Integer produtoId) {
        String query = "DELETE FROM produto_compra WHERE (compra_id = :compra_id AND produto_id = :produto_id)";

        entityManager.createNativeQuery(query)
                .setParameter("compra_id", compraId)
                .setParameter("produto_id", produtoId)
                .executeUpdate();

    }
}
