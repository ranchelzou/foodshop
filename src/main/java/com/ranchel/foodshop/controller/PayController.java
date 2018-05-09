package com.ranchel.foodshop.controller;

import com.ranchel.foodshop.dto.OrderDto;
import com.ranchel.foodshop.enums.ResultEnum;
import com.ranchel.foodshop.exception.ShopException;
import com.ranchel.foodshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/pay")
public class PayController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/create")
    public ModelAndView create(@RequestParam("oid") String oid
                             /* @RequestParam("url") String returnurl*/){
        //查询订单
        OrderDto orderDto=orderService.findOne(oid);
        if(orderDto==null){
            throw new ShopException(ResultEnum.ORDER_NOT_EXIST);
        }
        //发起支付
        return new ModelAndView("pay/create");

    }
}
