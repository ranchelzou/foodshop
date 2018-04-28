package com.ranchel.foodshop.dao;

import com.ranchel.foodshop.dateobject.OrderMaster;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterDaoTest {
    @Autowired
    private OrderMasterDao orderMasterDao;

    @Test
    public void saveTest(){
        OrderMaster orderMaster=new OrderMaster();
        orderMaster.setOid("123458");
        orderMaster.setBname("張山");
        orderMaster.setBphone("18804088689");
        orderMaster.setBaddress("中心街道");
        orderMaster.setBnickname("小麻烦888");
        orderMaster.setOamount(new BigDecimal(883.888));
        OrderMaster result=orderMasterDao.save(orderMaster);
        Assert.assertNotNull(result);


    }
    @Test
    public void findByBuyerNickname()throws Exception{
        PageRequest request=new PageRequest(1,3);

        Page<OrderMaster> result= orderMasterDao.findByBnickname("小麻烦888",request);
       Assert.assertNotEquals(0,result.getTotalElements());
        //System.out.println(result.getTotalElements());

    }

}