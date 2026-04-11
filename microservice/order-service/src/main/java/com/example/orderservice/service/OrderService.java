package com.example.orderservice.service;

import com.example.orderservice.dto.*;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    @Autowired
    private RestTemplate restTemplate;

    @CircuitBreaker(name = "default", fallbackMethod = "fallback")
    public OrderResponse createOrder(Long userId, Long productId, int quantity) {

        if (quantity <= 0) {
            throw new RuntimeException("Quantity must be greater than 0");
        }

        // CALL USER SERVICE
        String userUrl = "http://localhost:8081/users/" + userId;
        User user = restTemplate.getForObject(userUrl, User.class);

        // CALL PRODUCT SERVICE
        String productUrl = "http://localhost:8082/products/" + productId;
        Product product = restTemplate.getForObject(productUrl, Product.class);

        double total = product.getPrice() * quantity;

        return new OrderResponse(
                System.currentTimeMillis(),
                user.getName(),
                product.getName(),
                quantity,
                total
        );
    }

   
    public OrderResponse fallback(Long userId, Long productId, int quantity, Throwable t) {
        return new OrderResponse(0L, "Service Down", "Service Down", 0, 0);
    }
}