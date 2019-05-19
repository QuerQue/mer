package com.rental.serviceImpl;


import com.rental.dao.OrderStatusDao;
import com.rental.entity.OrderStatus;
import com.rental.service.OrderStatusService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderStatusServiceImpl implements OrderStatusService {

    @Autowired
    OrderStatusDao orderStatusDao;

    @Override
    public List<OrderStatus> getOrderStatuses() {
        return orderStatusDao.getOrderStatuses();
    }
}
