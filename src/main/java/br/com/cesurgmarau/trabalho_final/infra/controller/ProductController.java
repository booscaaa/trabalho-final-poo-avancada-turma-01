package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProductUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductUseCase productUseCase;

    @PostMapping("/product")
    public Product create(@RequestBody Product product) {
        productUseCase.create(product);
        return product;
    }

    @PutMapping("/product/{productID}")
    public Product update(@PathVariable int productID, @RequestBody Product product) {
        productUseCase.update(productID, product);
        return product;
    }

    @DeleteMapping("/product/{productID}")
    public void delete(@PathVariable int productID) {
        productUseCase.delete(productID);
    }

    @GetMapping("/product/{productID}")
    public Product getByID(@PathVariable int productID) {
        return productUseCase.getByID(productID);
    }

    @GetMapping("/product")
    public List<Product> fetch() {
        return productUseCase.fetch();
    }
}
