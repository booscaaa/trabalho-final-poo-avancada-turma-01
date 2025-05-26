package br.com.cesurgmarau.trabalho_final.core.domain.usecase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProductRepository;
import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProductUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductUseCaseImpl implements ProductUseCase {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        return productRepository.create(product);
    }

    @Override
    public Product update(int productID, Product product) {
        return productRepository.update(productID, product);
    }

    @Override
    public void delete(int productID) {
        productRepository.delete(productID);
    }

    @Override
    public Product getByID(int productID) {
        return productRepository.getByID(productID);
    }

    @Override
    public List<Product> fetch() {
        return productRepository.fetch();
    }
}
