package com.rental.dao;

import java.math.BigDecimal;
import java.util.List;

import com.rental.entity.Product;

public interface ProductDao {
    List<Product> getAllProducts(String name, BigDecimal price, String type, Integer quantity, String imageSource, Integer id);
    Product getProductById(Integer productId);
    void updateProduct(Product product);
    void createProduct(Product product);
    void deleteProduct(Integer productId);

}
