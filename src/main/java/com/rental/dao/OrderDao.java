package com.rental.dao;

import java.util.Date;
import java.util.List;

import com.rental.entity.Order;

public interface OrderDao {
    List<Order> getAllOrders(String productName, String customerName, Date purchaseDate);
    List<Order> getUserOrders(String productName, String customerName, Date purchaseDate, Integer userId);
    Order getOrderById(String orderId);
    void updateOrder(Order order);
    void createOrder(Order order);
    void deactivateOrder(String orderId);
}
