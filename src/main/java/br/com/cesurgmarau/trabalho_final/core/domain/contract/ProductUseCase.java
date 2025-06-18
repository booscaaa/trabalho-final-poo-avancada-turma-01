package br.com.cesurgmarau.trabalho_final.core.domain.contract;

import br.com.cesurgmarau.trabalho_final.core.domain.entity.Product;

import java.util.List;

public interface ProductUseCase {
    public String createProduct(Product product);

    public List<Product> getAllProduct();

    public Product listProductByID(int id);

    public String updateProduct(int id, Product product);

    public String deleteProduct(int id);
}
