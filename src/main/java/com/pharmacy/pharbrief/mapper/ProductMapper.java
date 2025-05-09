package com.pharmacy.pharbrief.mapper;

import com.pharmacy.pharbrief.dto.ProductDTO;
import com.pharmacy.pharbrief.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductDTO productDTO);
    ProductDTO toDTO(Product product);
}
