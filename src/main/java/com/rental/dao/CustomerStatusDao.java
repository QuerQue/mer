package com.rental.dao;

import java.util.List;

import com.rental.entity.CustomerStatus;

public interface CustomerStatusDao {
    List<CustomerStatus> getCustomerStatuses();
}
