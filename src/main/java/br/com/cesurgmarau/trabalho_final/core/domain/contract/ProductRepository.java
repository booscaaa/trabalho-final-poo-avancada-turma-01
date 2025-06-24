package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Product;

import java.util.List;

public interface ProductRepository {
    public Product create(Product product);
    public Product update(int productID, Product product);
    public void delete(int productID);
    public Product getByID(int productID);
    public List<Product> fetch();
}
