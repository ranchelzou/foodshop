package com.ranchel.foodshop.service.impl;

import com.ranchel.foodshop.dateobject.OrderDetail;
import com.ranchel.foodshop.dto.OrderDto;
import com.ranchel.foodshop.enums.OrderPayStatusEnum;
import com.ranchel.foodshop.enums.OrderStatusEnum;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private final String BUYER_NICKNAME="我是女王";
    private  final String oid="1525010991526574867";

    @Test
    public void create() throws Exception{
        OrderDto orderDto=new OrderDto();
        orderDto.setBname("一页纸");
        orderDto.setBaddress("我的家");
        orderDto.setBphone("13352203529");
        orderDto.setBnickname("我是女王");
        //购物车
        List<OrderDetail> orderDetailList=new ArrayList<>();
        OrderDetail o1=new OrderDetail();
        o1.setFid("1");
        o1.setFquantity(2);
        orderDetailList.add(o1);
        orderDto.setOrderDetailsList(orderDetailList);
        OrderDto result=orderService.create(orderDto);
        log.info("[创建订单] result={}",result);
    }

    @Test
    public void findOne() throws Exception{
        OrderDto orderDto=orderService.findOne(oid);
        log.info("[查询单个订单] orderDto={}" ,orderDto);
        Assert.assertEquals(oid,orderDto.getOid());
    }

    @Test
    public void findList() throws Exception{
        PageRequest request=new PageRequest(0,2);
        Page<OrderDto> orderDtoPage=orderService.findList(BUYER_NICKNAME,request);
    Assert.assertNotEquals(0,orderDtoPage.getTotalElements());
    }

    @Test
    public void cancel() throws Exception{
        OrderDto orderDto=orderService.findOne(oid);
       OrderDto result= orderService.cancel(orderDto);
       Assert.assertEquals(OrderStatusEnum.CANCEL.getCode(),result.getOstatus());
    }
    @Test
    public void finish()throws Exception{
        OrderDto orderDto=orderService.findOne(oid);
        OrderDto result= orderService.finish(orderDto);
        Assert.assertEquals(OrderStatusEnum.FINISHEND.getCode(),result.getOstatus());
    }
    @Test
    public void paid() throws Exception {
        OrderDto orderDto=orderService.findOne(oid);
        OrderDto result= orderService.paid(orderDto);
        Assert.assertEquals(OrderPayStatusEnum.SUCCESS.getCode(),result.getPstatus());
    }
}