package br.com.cesurgmarau.trabalho_final.core.UseCase.impl;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProductRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProductUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUseCaseImpl implements ProductUseCase {
    @Autowired
    private ProductRepository repository;
    private Product product;


    @Override
    public String createProduct(Product product) {
        return repository.createProduct(product);
    }

    @Override
    public List<Product> getAllProduct() {
        return repository.getAllProduct();

    }

    @Override
    public Product listProductByID(int id) {
        return repository.listProductByID(id);
    }

    @Override
    public String updateProduct(int id, Product product) {
        return repository.updateProduct(id, product);
    }

    public String deleteProduct(int id) {
        return repository.deleteProduct(id);
    }
}

