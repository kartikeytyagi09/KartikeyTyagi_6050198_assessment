package com.example.productservice.service;

import com.example.productservice.model.Product;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    private Map<Long, Product> productMap = new HashMap<>();

    public Product getProduct(Long id) {
        Product product = productMap.get(id);
        if (product == null) {
            throw new RuntimeException("Product not found");
        }
        return product;
    }

    public Product addProduct(Product product) {
        productMap.put(product.getId(), product);
        return product;
    }
}