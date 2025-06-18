package com.ratingreview.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @PostMapping
    public Product addProduct(@RequestBody Product product) {

        product.setAverageRating(0.0);
        product.setReviewCount(0);

        return productRepository.save(product);
    }
}
