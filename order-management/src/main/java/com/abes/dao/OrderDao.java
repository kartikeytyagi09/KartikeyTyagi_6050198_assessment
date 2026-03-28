package com.abes.dao;

import java.util.List;
import com.abes.entity.Order;

public interface OrderDao {

    void addOrder(Order order);

    Order viewOrderById(int id);

    List<Order> viewOrdersByCustomerName(String name);

}