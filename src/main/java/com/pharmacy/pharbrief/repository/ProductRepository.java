
package com.pharmacy.pharbrief.repository;

import com.pharmacy.pharbrief.model.Product;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    // List<Product> getProductsByPriceGreaterThan(double prix);

    @Query("select p FROM Product p WHERE p.price > :priceG")
    List<Product> getProductsByPriceGreaterThan(@Param("priceG") double priceG );

    @Query("select p from Product p where p.quantity < :quantity")
    List<Product> findProductsWithQunatityLessThan(@Param("quantity") int quantity);

    List<Product> findByQuantityLessThan(int quantity);


    @Query("select p from Product p where lower(p.name) like lower(concat('%', :keyword ,'%') )")

    List<Product> getProductByName(@Param("keyword") String keyword);
}
