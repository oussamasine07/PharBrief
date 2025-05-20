package com.pharmacy.pharbrief.service;

import com.pharmacy.pharbrief.dto.ProductDTO;
import com.pharmacy.pharbrief.mapper.ProductDTOMapper;
import com.pharmacy.pharbrief.mapper.ProductMapper;
import com.pharmacy.pharbrief.model.Product;
import com.pharmacy.pharbrief.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.ResourceTransactionManager;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductDTOMapper productDTOMapper;
    private final ProductMapper productMapper;

    @Autowired
    public ProductService (
            final ProductRepository productRepository,
            final ProductDTOMapper productDTOMapper,
            final ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productDTOMapper = productDTOMapper;
        this.productMapper = productMapper;
    }

    public List<ProductDTO> getAllProducts () {
        return productRepository.findAll()
                .stream()
                //.map(productDTOMapper)
                //.map(product -> productMapper.toDTO(product))
                .map(productMapper::toDTO)// METHOD REFERENCE
                .collect(Collectors.toList());
    }

    public Optional<Product> getProdcutById (Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getPriceGreater(double priceG){
        return productRepository.getProductsByPriceGreaterThan(priceG);
    }
    public List<Product> getProductsWithQunatityLessThan(int quantity){
        return productRepository.findProductsWithQunatityLessThan(quantity);
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

//    public List<Product> getquanityInferieur(int quantity){
//        return productRepository.findByQuantityLessThan(quantity);
//    }


//    public int countProducts (double price) {
//        return productRepository.countProductByPrice(price);
//    }
//
//    public Product findProductByName ( String name ) {
//        return productRepository.findProductByName(name);
//    }

}















