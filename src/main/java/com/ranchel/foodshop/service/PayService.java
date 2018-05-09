package com.ranchel.foodshop.service;

import com.ranchel.foodshop.dto.OrderDto;
import org.hibernate.criterion.Order;

public interface PayService {
    void create(OrderDto orderDto);
}
