package com.pharmacy.pharbrief.repository;

import com.pharmacy.pharbrief.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    public int countProductByPrice ( double price );
}
