package com.rental.dto;


import java.math.BigDecimal;

public class ProductSearch {
    private String name;
    private BigDecimal price;
    private String type;
    private Integer quantity;
    private String imageSource;
    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    
    public String getSource(){
    	return imageSource;
    }
    
    public void setSource(String imageSource){
    	this.imageSource = imageSource;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

    
}
