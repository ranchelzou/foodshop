package com.ranchel.foodshop.service;

import com.ranchel.foodshop.dto.OrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface OrderService {
    /**创建订单*/
    OrderDto create(OrderDto orderDto);
    /**查询单个订单*/
    OrderDto findOne(String oid);
    /**买家查询订单列表*/
    Page<OrderDto> findList(String bnickname, Pageable pageable);
    /**卖家查询订单列表*/
    Page<OrderDto> findList( Pageable pageable);
    /**取消订单*/
    OrderDto cancel(OrderDto orderDto);
    /**完结订单*/
    OrderDto finish(OrderDto orderDto);
    /**支付订单*/
    OrderDto paid(OrderDto orderDto);
}
