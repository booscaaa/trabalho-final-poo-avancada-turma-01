package br.com.cesurgmarau.trabalho_final.application.UseCase;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProductUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductUseCaseImpl implements ProductUseCase {
    @Override
    public List<Product> listAllProducts() {
        return List.of();
    }

    @Override
    public Product listByID(int id) {
        return null;
    }

    @Override
    public void createProduct(Product product) {

    }

    @Override
    public String deleteProduct(int id) {
        return "";
    }

    @Override
    public String updateProduct(int id, Product product) {
        return "";
    }
}
