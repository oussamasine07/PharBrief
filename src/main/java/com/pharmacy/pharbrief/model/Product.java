package com.pharmacy.pharbrief.model;

import com.pharmacy.pharbrief.validation.ValidatProductType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "name is required")
    @Size(min = 5, message = "name must be at least 5 charachters")
    private String name;

    @NotBlank(message = "description is required")
    @Size(min = 5, message = "description must be at least 5 charachters")
    private String description;

    @Positive(message = "price can not be negative value")
    private double price;

    @Positive(message = "quantity can not be negative value")
    private int quantity;

    @NotNull(message = "product type is required")
    @ValidatProductType
    private ProductType productType;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductType getProductType() {
        return this.productType;
    }

    public void setProductType ( ProductType productType ) {
        this.productType = productType;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", productType=" + productType +
                '}';
    }
}
