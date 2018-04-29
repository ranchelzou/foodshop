package com.ranchel.foodshop.service.impl;

import com.ranchel.foodshop.dateobject.OrderDetail;
import com.ranchel.foodshop.dto.OrderDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class OrderServiceImplTest {
    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create() {
        OrderDto orderDto=new OrderDto();
        orderDto.setBname("一页纸");
        orderDto.setBaddress("我的家");
        orderDto.setBphone("13352203529");
        orderDto.setBnickname("我是女王");
        //购物车
        List<OrderDetail> orderDetailList=new ArrayList<>();
        OrderDetail o1=new OrderDetail();
        o1.setFid("1");
        o1.setFquantity(1);
        orderDetailList.add(o1);
        orderDto.setOrderDetailsList(orderDetailList);
        OrderDto result=orderService.create(orderDto);
        log.info("[创建订单] result={}",result);
    }

    @Test
    public void findOne() {
    }

    @Test
    public void findList() {
    }

    @Test
    public void cancel() {
    }
}