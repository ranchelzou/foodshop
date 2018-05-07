package com.ranchel.foodshop.service.impl;

import com.ranchel.foodshop.dto.OrderDto;
import com.ranchel.foodshop.enums.ResultEnum;
import com.ranchel.foodshop.exception.ShopException;
import com.ranchel.foodshop.service.BuyerService;
import com.ranchel.foodshop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BuyerServiceImpl  implements BuyerService {
    @Autowired
    private OrderService orderService;
    @Override
    public OrderDto findOrderOne(String bnickname, String oid) {
       return checkOrderOwner(bnickname, oid);
    }

    @Override
    public OrderDto cancelOrder(String bnickname, String oid) {
        OrderDto orderDto=checkOrderOwner(bnickname, oid);

        if(orderDto==null){
           log.error("[取消订单] 查不到该订单,oid={}",oid);
           throw new ShopException(ResultEnum.ORDER_NOT_EXIST);
        }
        return orderService.cancel(orderDto);
    }
    private OrderDto checkOrderOwner(String bnickname, String oid) {
        OrderDto orderDto=orderService.findOne(oid);
        if(orderDto==null){
            return null;
        }
        //判断是否是自己的订单
        if(!orderDto.getBnickname().equalsIgnoreCase(bnickname)){
            log.error("[查询订单] 订单的openid不一致, openid={},orderDto={}",bnickname,orderDto);
            throw new ShopException(ResultEnum.ORDER_OWNER_ERROE);
        }
        return orderDto;
    }
}
