package com.ranchel.foodshop.dao;

import com.ranchel.foodshop.dateobject.Buyer_Info;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuyerInfoDaoTest {
    @Autowired
    private   BuyerInfoDao buyerInfoDao;



    @Test
    public  void save(){

        Buyer_Info buyer_info=new Buyer_Info();
        buyer_info.setId(1);
        buyer_info.setUsername("13940517937");
        buyer_info.setPassword("abc");
        Buyer_Info result=buyerInfoDao.save(buyer_info);
        Assert.assertNotNull(result);
    }
    @Test
    public void findByUsernameAndPassword() {
      Buyer_Info result= buyerInfoDao.findByUsernameAndPassword("13352203529","abc") ;
      Assert.assertNotNull(result);
    }
    @Test
    public void findByUsername(){
        Buyer_Info result= buyerInfoDao.findByUsername("13940517937") ;
        System.out.println(result.getUsername());
        ;



    }
}