package br.com.cesurgmarau.trabalho_final.infra.database;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.repository.CompraRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Compra;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Produto;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.ProdutoCompra;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CompraRepositoryImpl implements CompraRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    @Override
    public void createCompra(Compra compra) {
        String query = "INSERT INTO compra (valor_total, usuario_id) VALUES (:valor_total, :usuario_id)";

        entityManager.createNativeQuery(query)
                .setParameter("valor_total", compra.getValorTotal())
                .setParameter("usuario_id", compra.getUsuario().getId())
                .executeUpdate();

        Integer compraId = (Integer) entityManager.createNativeQuery("SELECT MAX(id) FROM compra").getSingleResult();

        for (var produtoCompra : compra.getProdutos()) {
            String insertProdutoCompra = "INSERT INTO produto_compra (compra_id, produto_id, quantidade) " +
                    "VALUES (:compra_id, :produto_id, :quantidade)";
            entityManager.createNativeQuery(insertProdutoCompra)
                    .setParameter("compra_id", compraId)
                    .setParameter("produto_id", produtoCompra.getProduto().getId())
                    .setParameter("quantidade", produtoCompra.getQuantidade())
                    .executeUpdate();
        }
    }

    @Override
    public List<Compra> readCompra() {
        String query = "SELECT * FROM compra";

        List<Compra> compras = entityManager.createNativeQuery(query, Compra.class)
                .getResultList();

        for (Compra compra : compras) {
            List<Object[]> produtosRaw = entityManager.createNativeQuery(
                            "SELECT pc.produto_id, p.nome, pc.quantidade " +
                                    "FROM produto_compra pc " +
                                    "JOIN produto p ON pc.produto_id = p.id " +
                                    "WHERE pc.compra_id = :compra_id")
                    .setParameter("compra_id", compra.getId())
                    .getResultList();

            List<ProdutoCompra> produtos = produtosRaw.stream()
                    .map(row -> {
                        Produto produto = new Produto();
                        produto.setId((Integer) row[0]);
                        produto.setNome((String) row[1]);

                        ProdutoCompra produtoCompra = new ProdutoCompra();
                        produtoCompra.setCompra(compra);
                        produtoCompra.setProduto(produto);
                        produtoCompra.setQuantidade((Integer) row[2]);

                        return produtoCompra;
                    })
                    .toList();

            compra.setProdutos(produtos);
        }

        return compras;
    }

    @Override
    public Compra readCompra(Integer id) {
        String queryCompra = "SELECT * FROM compra WHERE id = :id";
        Compra compra = (Compra) entityManager.createNativeQuery(queryCompra, Compra.class)
                .setParameter("id", id)
                .getSingleResult();

        List<Object[]> produtosRaw = entityManager.createNativeQuery(
                        "SELECT pc.produto_id, p.nome, pc.quantidade " +
                                "FROM produto_compra pc " +
                                "JOIN produto p ON pc.produto_id = p.id " +
                                "WHERE pc.compra_id = :compra_id")
                .setParameter("compra_id", compra.getId())
                .getResultList();

        List<ProdutoCompra> produtos = produtosRaw.stream()
                .map(row -> {
                    Produto produto = new Produto();
                    produto.setId((Integer) row[0]);
                    produto.setNome((String) row[1]);

                    ProdutoCompra produtoCompra = new ProdutoCompra();
                    produtoCompra.setCompra(compra);
                    produtoCompra.setProduto(produto);
                    produtoCompra.setQuantidade((Integer) row[2]);

                    return produtoCompra;
                })
                .toList();

        compra.setProdutos(produtos);
        return compra;
    }

    @Transactional
    @Override
    public void updateCompra(Integer id, Compra compra) {
        String query = "UPDATE compra SET valor_total = :valor_total, usuario_id = :usuario_id WHERE id = :id";
        entityManager.createNativeQuery(query)
                .setParameter("valor_total", compra.getValorTotal())
                .setParameter("usuario_id", compra.getUsuario().getId())
                .setParameter("id", id)
                .executeUpdate();

        String deleteProdutosQuery = "DELETE FROM produto_compra WHERE compra_id = :compra_id";
        entityManager.createNativeQuery(deleteProdutosQuery)
                .setParameter("compra_id", id)
                .executeUpdate();

        String insertProdutoCompra = "INSERT INTO produto_compra (compra_id, produto_id, quantidade) " +
                "VALUES (:compra_id, :produto_id, :quantidade)";

        for (ProdutoCompra pc : compra.getProdutos()) {
            String insertProdutoCompraIteracao = "INSERT INTO produto_compra (compra_id, produto_id, quantidade) " +
                    "VALUES (:compra_id, :produto_id, :quantidade)";

            entityManager.createNativeQuery(insertProdutoCompra)
                    .setParameter("compra_id", id)
                    .setParameter("produto_id", pc.getProduto().getId())
                    .setParameter("quantidade", pc.getQuantidade())
                    .executeUpdate();
        }
    }

    @Transactional
    @Override
    public void deleteCompra(Integer id) {
        String deleteProdutos = "DELETE FROM produto_compra WHERE compra_id = :compra_id";
        entityManager.createNativeQuery(deleteProdutos)
                .setParameter("compra_id", id)
                .executeUpdate();

        String deleteCompra = "DELETE FROM compra WHERE id = :id";
        entityManager.createNativeQuery(deleteCompra)
                .setParameter("id", id)
                .executeUpdate();
    }
}
