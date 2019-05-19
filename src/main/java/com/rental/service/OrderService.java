package com.rental.service;

import java.util.Date;
import java.util.List;

import com.rental.entity.Order;

public interface OrderService {
    List<Order> getAllOrders(String productName, String customerName, Date purchaseDate);
    List<Order> getUserOrders(String productName, String customerName, Date purchaseDate, Integer userId);
    Order getOrderById(String orderId);
    boolean updateOrder(Order order);
    boolean createOrder(Order order);
    boolean deactivateOrder(String orderId);
    String showErrorMessage();
}
