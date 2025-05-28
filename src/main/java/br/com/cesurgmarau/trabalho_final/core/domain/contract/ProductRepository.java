package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> listAllProducts ();
    public Product listByID (int id);
    public void createProduct (Product product);
    public String deleteProduct (int id);
    public String updateProduct (int id, Product product);
}
