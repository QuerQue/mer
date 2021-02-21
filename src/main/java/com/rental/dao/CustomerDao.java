package com.rental.dao;

import java.util.Date;  
import java.util.List;

import com.rental.entity.Customer;

public interface CustomerDao {
    List<Customer> getAllCustomers(String name, Integer personalId, Date birthDate, String address);
    Customer getCustomerById(Integer customerId);
    void updateCustomer(Customer customer);
    void createCustomer(Customer customer);
    void deactivateCustomer(Integer customerId);    

}
