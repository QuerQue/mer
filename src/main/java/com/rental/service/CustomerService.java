package com.rental.service;


import java.util.Date;
import java.util.List;

import com.rental.entity.Customer;

public interface CustomerService {

    Customer getCustomerById(Integer customerId);
    boolean createCustomer(Customer customer);
    boolean updateCustomer(Customer customer);
    boolean deactivateCustomer(Integer customerId);
    List<Customer> getAllCustomers(String name, Integer personalId, Date birthDate, String address);
    String showErrorMessage();
}
