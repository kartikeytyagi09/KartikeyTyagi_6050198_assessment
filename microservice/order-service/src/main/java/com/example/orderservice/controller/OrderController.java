package com.example.orderservice.controller;

import com.example.orderservice.dto.OrderResponse;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService service;

    @PostMapping
    public OrderResponse create(@RequestBody Map<String, Integer> req) {

        Long userId = Long.valueOf(req.get("userId"));
        Long productId = Long.valueOf(req.get("productId"));
        int quantity = req.get("quantity");

        return service.createOrder(userId, productId, quantity);
    }
}