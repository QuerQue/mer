package com.rental.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.constant.Constant;
import com.rental.dto.ProductSearch;
import com.rental.serviceImpl.OrderServiceImpl;
import com.rental.serviceImpl.ProductServiceImpl;

@Controller
@RequestMapping(value="/cart")
public class CartController {
	
    @Autowired
    OrderServiceImpl orderService;
    
    @Autowired
    ProductServiceImpl productService;
    
	@RequestMapping
	public String get(HttpServletRequest request){
		return "redirect:/cart/"+request.getSession(true).getId();	
	}
	
	@RequestMapping(value="/{cartId}", method = RequestMethod.GET)
    public String getOrder(@PathVariable String cartId, Model model, @ModelAttribute("ProductSearch") ProductSearch productSearch){
        model.addAttribute(Constant.CART, orderService.getOrderById(cartId));
        model.addAttribute(Constant.PRODUCT, productService.getProductById(109));
		return Constant.CART;
	}
}
