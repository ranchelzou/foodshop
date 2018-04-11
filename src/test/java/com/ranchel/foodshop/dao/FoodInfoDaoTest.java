package com.ranchel.foodshop.dao;

import com.ranchel.foodshop.dateobject.FoodInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodInfoDaoTest {
    @Autowired
    private FoodInfoDao fiDao;

    @Test
    public  void save(){
        FoodInfo fi=new FoodInfo();
        fi.setFid("5210");
        fi.setFname("爱的味道");
        fi.setFprice(new BigDecimal(5.21));
        fi.setFdescription("单身狗专属");
        fi.setFimage("http://xx.jpg");
        fi.setCtype(52);
        FoodInfo result=fiDao.save(fi);
        Assert.assertNotNull(result);
    }

}