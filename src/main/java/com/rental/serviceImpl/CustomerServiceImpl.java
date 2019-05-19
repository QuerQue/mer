package com.rental.serviceImpl;

import com.constant.Constant;
import com.rental.dao.CustomerDao;
import com.rental.entity.Customer;
import com.rental.entity.User;
import com.rental.service.CustomerService;
import com.rental.utility.UserLoginUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerDao customerDao;

    @Autowired
    UserLoginUtils userLoginUtils;

    @Autowired
    UserServiceImpl userService;

    private String errorMessage;

    public Customer getCustomerById(Integer customerId) {
        return customerDao.getCustomerById(customerId);
    }

    public boolean createCustomer(Customer customer) {
        String loggedUserName = userLoginUtils.getUserLogin().getUsername();
        User loggedUser = userService.getUserByUsername(loggedUserName);
        Integer loggerUserId = loggedUser.getId();
        customer.setUserId(loggerUserId);
        customer.setStatus(1);

        if (customer.getName() == null || customer.getName().isEmpty() ||
                customer.getPersonalId() == null ||
                customer.getAddress() == null || customer.getAddress().isEmpty()) {
            errorMessage = Constant.ERR_ALL_FIELDS;
            return false;
        } else {
            customerDao.createCustomer(customer);
            return true;
        }
    }

    public boolean updateCustomer(Customer customer) {
        String loggedUserName = userLoginUtils.getUserLogin().getUsername();
        User loggedUser = userService.getUserByUsername(loggedUserName);
        Integer loggerUserId = loggedUser.getId();
        customer.setUserId(loggerUserId);

        if (customer.getName() == null || customer.getName().isEmpty() ||
                customer.getPersonalId() == null ||
                customer.getAddress() == null || customer.getAddress().isEmpty() ||
                customer.getStatus() == null) {
            errorMessage = Constant.ERR_ALL_FIELDS;
            return false;
        } else {
            customerDao.updateCustomer(customer);
            return true;
        }
    }

    public boolean deactivateCustomer(Integer customerId) {
        customerDao.deactivateCustomer(customerId);
        return true;
    }

    public List<Customer> getAllCustomers(String name, Integer personalId, Date birthDate, String address) {
        return customerDao.getAllCustomers(name, personalId, birthDate, address);
    }

    @Override
    public String showErrorMessage() {
        return errorMessage;
    }
}
