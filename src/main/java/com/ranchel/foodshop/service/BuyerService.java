package com.ranchel.foodshop.service;

import com.ranchel.foodshop.dto.OrderDto;

//买家
public interface BuyerService {
    //查询一个订单
    OrderDto findOrderOne( String bnickname,String oid);
    //取消订单
    OrderDto cancelOrder(String bnickname,String oid);
}
