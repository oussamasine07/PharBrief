package com.pharmacy.pharbrief.service;

import com.pharmacy.pharbrief.model.Product;
import com.pharmacy.pharbrief.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService (final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts () {
        return productRepository.findAll();
    }

    public Optional<Product> getProdcutById (Long id) {
        return productRepository.findById(id);
    }

    public Product createProduct (Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct (Long id, Product updatedProduct) {
        Product product = productRepository.findById(id).orElseThrow();

        product.setName(updatedProduct.getName());
        product.setDescription(updatedProduct.getDescription());
        product.setPrice(updatedProduct.getPrice());
        product.setQuantity(updatedProduct.getQuantity());

        return productRepository.save(product);
    }

    public void deleteProduct (Long id) {
        productRepository.deleteById(id);
    }

}















