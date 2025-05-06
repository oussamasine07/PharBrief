package com.pharmacy.pharbrief.controllers;

import com.pharmacy.pharbrief.model.Product;
import com.pharmacy.pharbrief.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;
    public ProductController (final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllTasks () {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getProdcutById(id).orElseThrow();
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/{id}")
    public Product update (
            @RequestBody Product product,
            @PathVariable Long id
    ) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id) {
        productService.deleteProduct(id);
    }

}
