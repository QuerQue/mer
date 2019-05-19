package com.rental.serviceImpl;

import com.constant.Constant;
import com.rental.dao.OrderDao;
import com.rental.dao.ProductDao;
import com.rental.entity.Order;
import com.rental.entity.Product;
import com.rental.entity.User;
import com.rental.security.UserLogin;
import com.rental.service.OrderService;
import com.rental.utility.UserLoginUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    UserLoginUtils userLoginUtils;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    ProductDao productDao;

    private String errorMessage;

    public List<Order> getAllOrders(String productName, String customerName, Date purchaseDate) {
        return orderDao.getAllOrders(productName, customerName, purchaseDate);
    }

    public List<Order> getUserOrders(String productName, String customerName, Date purchaseDate, Integer userId) {
        return orderDao.getUserOrders(productName, customerName, purchaseDate, userId);
    }

    public Order getOrderById(String orderId) {
        return orderDao.getOrderById(orderId);
    }

    public boolean updateOrder(Order order) {
        Date now = new Date();
        String loggedUserName = userLoginUtils.getUserLogin().getUsername();
        User loggedUser = userService.getUserByUsername(loggedUserName);
        Integer loggerUserId = loggedUser.getId();
        order.setUserId(loggerUserId);
        order.setPurchaseDate(now);

        Integer orderProductId = order.getProductId();
        Product product = productDao.getProductById(orderProductId);

        if (product.getQuantity() < order.getQuantity()){
            errorMessage = Constant.ERR_INSUFFICIENT_QUANTITY;
            return false;
        }
        else {
            product.setQuantity(product.getQuantity() - order.getQuantity());
            productDao.updateProduct(product);
            orderDao.updateOrder(order);
            return true;
        }
    }

    public boolean createOrder(Order order) {
        Date now = new Date();
        Integer loggedUserId = ((UserLogin) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId();
        order.setUserId(loggedUserId);
        order.setPurchaseDate(now);
        order.setStatus(1);
        //order.setId("2F0D6B437BE3BAA551A65E3A1B373C03");
        Integer orderProductId = order.getProductId();
        Product product = productDao.getProductById(orderProductId);

        if (order.getQuantity() == null) {
            errorMessage = Constant.ERR_ALL_FIELDS;
            return false;
        }
        if (product.getQuantity() < order.getQuantity()){
            errorMessage = Constant.ERR_INSUFFICIENT_QUANTITY;
            return false;
        }
        else {
            product.setQuantity(product.getQuantity() - order.getQuantity());
            productDao.updateProduct(product);
            orderDao.createOrder(order);
            return true;
        }
    }

    @Override
    public boolean deactivateOrder(String orderId) {
        Order order = orderDao.getOrderById(orderId);
        Integer orderProductId = order.getProductId();
        Product product = productDao.getProductById(orderProductId);
        product.setQuantity(product.getQuantity() + order.getQuantity());
        productDao.updateProduct(product);
        orderDao.deactivateOrder(orderId);
        return true;
    }

    @Override
    public String showErrorMessage() {
        return errorMessage;
    }
}
