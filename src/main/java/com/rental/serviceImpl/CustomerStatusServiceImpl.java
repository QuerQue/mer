package com.rental.serviceImpl;

import com.rental.dao.CustomerDao;
import com.rental.dao.CustomerStatusDao;
import com.rental.entity.CustomerStatus;
import com.rental.service.CustomerStatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerStatusServiceImpl implements CustomerStatusService {

    @Autowired
    CustomerStatusDao customerStatusDao;

    @Override
    public List<CustomerStatus> getCustomerStatuses() {
        return customerStatusDao.getCustomerStatuses();
    }
}
