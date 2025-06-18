package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProductUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class ProductController {
    @Autowired
    ProductUseCase productUseCase;

    @PostMapping("/product")
    public String createProduct(@RequestBody Product product) {
        productUseCase.createProduct(product);
        return "Produto criado com sucesso!";
    }

    @PutMapping("/product/{id}")
    public String updateProduct(@PathVariable int id, @RequestBody Product product) {
        productUseCase.updateProduct(id, product);
        return "Produto alterado com sucesso!";
    }

    @GetMapping("/product")
    public List<Product> getAllProduct() {
        List<Product> products = productUseCase.getAllProduct();
        return products;
    }

    @GetMapping("/product/{id}")
    public Product listProductByID(@PathVariable int id) {
        return productUseCase.listProductByID(id);
    }

    @DeleteMapping("/product/{id}")
    public String deleteProduct(@PathVariable int id) {
        return productUseCase.deleteProduct(id);
    }
}
