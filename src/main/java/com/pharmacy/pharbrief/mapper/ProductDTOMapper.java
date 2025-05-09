package com.pharmacy.pharbrief.mapper;

import com.pharmacy.pharbrief.dto.ProductDTO;
import com.pharmacy.pharbrief.model.Product;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ProductDTOMapper implements Function<Product, ProductDTO> {
    @Override
    public ProductDTO apply(Product product) {
        return new ProductDTO(
                product.getName(),
                product.getPrice()
        );
    }
}
