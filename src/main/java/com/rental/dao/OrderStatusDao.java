package com.rental.dao;


import java.util.List;

import com.rental.entity.OrderStatus;

public interface OrderStatusDao {

    List<OrderStatus> getOrderStatuses();
}
