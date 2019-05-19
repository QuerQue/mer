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
import com.rental.entity.Order;
import com.rental.serviceImpl.CustomerServiceImpl;
import com.rental.serviceImpl.OrderServiceImpl;
import com.rental.serviceImpl.OrderStatusServiceImpl;
import com.rental.serviceImpl.ProductServiceImpl;
import com.rental.serviceImpl.UserServiceImpl;



@Controller
public class CatalogController {
	
    @Autowired
    OrderServiceImpl orderService;

    @Autowired
    ProductServiceImpl productService;

    @Autowired
    CustomerServiceImpl customerService;

    @Autowired
    OrderStatusServiceImpl orderStatusService;

    @Autowired
    UserServiceImpl userService;

    private String errorMessage;

    
	@RequestMapping(Constant.CATALOG_URL)
	public String showCatalog(Model model, @ModelAttribute("ProductSearch") ProductSearch productSearch){
		model.addAttribute("products", productService.getAllProducts(productSearch.getName(),
                productSearch.getPrice(), productSearch.getType(), productSearch.getQuantity(), productSearch.getSource(), productSearch.getId()));
	        return Constant.CATALOG;
	    }
	
   /* @RequestMapping(Constant.ORDER_NOW)
    public String orderNow(@PathVariable Integer id){
        //productService.ordernow(id);
        return Constant.CATALOG_REDIRECT_URL;
    }*/
    
    @RequestMapping(value = Constant.ORDER_NOW, method = RequestMethod.GET)
    public String saveOrder(@PathVariable Integer prodId, HttpServletRequest request, @ModelAttribute("order") Order order, Model model) {
    
    	String sessionId = request.getSession(true).getId();
        boolean successCreateOrder;
        order.setProductId(prodId);
        order.setQuantity(1);
        System.out.println(order.getId());
        if (order.getId() == null) {
            order.setId(sessionId);
            successCreateOrder = orderService.createOrder(order);
            if (successCreateOrder) {
                return Constant.CATALOG_REDIRECT_URL;
            }{
            	return errorMessage;
            }
        }else {
        	return errorMessage;
        }
    }
}
