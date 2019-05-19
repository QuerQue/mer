package com.rental.service;

import java.math.BigDecimal;
import java.util.List;

import com.rental.entity.Product;

public interface ProductService {
    Product getProductById(Integer productId);
    boolean createProduct(Product product);
    boolean updateProduct(Product product);
    boolean deleteProductById(Integer productId);
    List<Product> getAllProducts(String name, BigDecimal price, String type, Integer quantity, String imageSource, Integer id);
    String showErrorMessage();
}
