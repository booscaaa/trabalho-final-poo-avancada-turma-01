package br.com.cesurgmarau.trabalho_final.infra.database.repository;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProductRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;


    @Transactional
    @Override
    public String createProduct(Product product) {
        var query = "INSERT INTO products (name, price, quantity) VALUES (:name, :price, :quantity);";

        entityManager.createNativeQuery(query, Product.class)
                .setParameter("name", product.getName())
                .setParameter("price", product.getPrice())
                .setParameter("quantity", product.getQuantity())
                .executeUpdate();

        return "produto criado com sucesso";

    }

    @Override
    public List<Product> getAllProduct() {
        var query = "SELECT * FROM products;";

        return (List<Product>) entityManager.createNativeQuery(query, Product.class).getResultList();
    }

    @Override
    public Product listProductByID(int id) {
        var query = "SELECT * FROM products WHERE id = :id";

        return (Product) entityManager.createNativeQuery(query, Product.class)
                .setParameter("id", id)
                .getSingleResult();

    }

    @Transactional
    @Override
    public String updateProduct(int id, Product product) {
        var query = "UPDATE products SET name = :name,price = :price,quantity = :quantity WHERE id = :id";

        entityManager.createNativeQuery(query, Product.class)
                .setParameter("name", product.getName())
                .setParameter("price", product.getPrice())
                .setParameter("quantity", product.getQuantity())
                .setParameter("id", id)
                .executeUpdate();
        return "produto alterado com sucesso!";
    }

    @Transactional
    @Override
    public String deleteProduct(int id) {
        var query = "DELETE FROM products WHERE id = :id";

        entityManager.createNativeQuery(query, Product.class).setParameter("id", id).executeUpdate();
        return "produto deletado com sucesso!";
    }

}


