package com.ranchel.foodshop.dao;

import com.ranchel.foodshop.dateobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailDaoTest {
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Test
    public  void saveTest(){
        OrderDetail orderDetail=new OrderDetail();
        orderDetail.setDid("123");
        orderDetail.setOid("789");
        orderDetail.setFid("3");
        orderDetail.setFimage("jajajaj");
        orderDetail.setFquantity(20);
        orderDetail.setFname("hate you");
        orderDetail.setFprice(new BigDecimal(88.5));
        OrderDetail result=orderDetailDao.save(orderDetail);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByOid ()throws Exception{
        List<OrderDetail>orderDetailList=orderDetailDao.findByOid("789");
        Assert.assertNotEquals(0, orderDetailList.size());

   }

}