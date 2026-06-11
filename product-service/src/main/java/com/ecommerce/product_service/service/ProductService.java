package com.ecommerce.product_service.service;

import com.ecommerce.product_service.model.Product;
import com.ecommerce.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // සියලුම නිෂ්පාදන ලබාගැනීම
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // අලුත් නිෂ්පාදනයක් ඇතුළත් කිරීම (Admin සතු පහසුකම)
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}