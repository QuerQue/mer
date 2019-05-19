/*package com.rental.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.swing.*;
import java.util.Date;


@Entity
@Table(name= "STORE_CART")
public class Cart {

    //@Id
    @Column(name = "PRODUCT_ID")
    //@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STORE_CUSTOMER_ID")
    //@SequenceGenerator(name = "STORE_CUSTOMER_ID", sequenceName = "STORE_CUSTOMER_ID", allocationSize = 1, initialValue = 1)
    private Integer id;

    @Column(name = "QUANTITY")
    private Integer quantity;

    @Column(name = "PRICE")
    private Integer price;

    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
*/