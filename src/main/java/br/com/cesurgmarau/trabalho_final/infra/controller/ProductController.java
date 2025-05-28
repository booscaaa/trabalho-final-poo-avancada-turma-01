package br.com.cesurgmarau.trabalho_final.infra.controller;

import br.com.cesurgmarau.trabalho_final.core.domain.contract.ProductUseCase;
import br.com.cesurgmarau.trabalho_final.core.domain.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController //denomina o local do controller para o meio externo
public class ProductController {


        @Autowired
        private ProductUseCase productUseCase;


        @GetMapping("/product")
        public List<Product> listAllProducts() {
            return productUseCase.listAllProducts();
        }

        @GetMapping("/product/{id}")
        public Product listByID (@PathVariable int id) {
            return productUseCase.listByID(id);
        }

        @PostMapping("/product")
        public void createProduct (@RequestBody Product product) {
            productUseCase.createProduct(product);
        }

        @DeleteMapping("/product/{id}")
        public String deleteProduct (@PathVariable int id) {
            return productUseCase.deleteProduct(id);
        }

        @PutMapping("/product/{id}")
        public String updateProduct (@PathVariable int id, @RequestBody Product product) {
            return productUseCase.updateProduct(id, product);
        }
    }

