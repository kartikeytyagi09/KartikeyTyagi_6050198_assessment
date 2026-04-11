package com.example.orderservice.dto;

public class OrderResponse {

    private Long orderId;
    private String userName;
    private String productName;
    private int quantity;
    private double totalPrice;

    public OrderResponse(Long orderId, String userName, String productName, int quantity, double totalPrice) {
        this.orderId = orderId;
        this.userName = userName;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public Long getOrderId() { return orderId; }
    public String getUserName() { return userName; }
    public String getProductName() { return productName; }
    public int getQuantity() { return quantity; }
    public double getTotalPrice() { return totalPrice; }
}