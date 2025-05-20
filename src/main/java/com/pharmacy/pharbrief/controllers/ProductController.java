package com.pharmacy.pharbrief.controllers;

import com.pharmacy.pharbrief.dto.ProductDTO;
import com.pharmacy.pharbrief.model.Product;
import com.pharmacy.pharbrief.repository.ProductRepository;
import com.pharmacy.pharbrief.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    private final ProductService productService;
    public ProductController (final ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductDTO> getAllTasks () {
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

//    @GetMapping("/count/{price}")
//    public int countPriceProducts (@PathVariable Integer price) {
//        return productService.countProducts(price);
//    }

//    @GetMapping("/find-product")
//    public Product findByName (@RequestBody Product  product) {
//        System.out.println(product);
//        return productService.findProductByName(product.getName());
//    }


    @GetMapping("/greater-price/{prix}")

    public  List<Product> greaterPrice(@PathVariable double prix){

        return  productService.getPriceGreater(prix);

    }
    @GetMapping({"/Quantity-less-than/{quantity}", "/quantity/{quantity}"})

    public List<Product> findByQuantityLessThan(@PathVariable int quantity){

        return productService.getProductsWithQunatityLessThan(quantity);
    }
}
