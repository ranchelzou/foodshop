package com.ranchel.foodshop.service.impl;

import com.ranchel.foodshop.dateobject.FoodInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FoodServiceImplTest {
    @Autowired
    private FoodServiceImpl foodService;
    @Test
    public void findOne() throws Exception{
        FoodInfo fi=foodService.findOne("5210");
        Assert.assertEquals("5210",fi.getFid());
    }
    @Test
    public void findAll() {
        PageRequest result=new PageRequest(1,2);
        Page<FoodInfo> fiPage=foodService.findAll(result);
       // System.out.println(fiPage.getTotalElements());
        Assert.assertNotEquals(0,fiPage.getTotalElements());
    }

    @Test
    public void findByCtypeIn() {
        List<FoodInfo>fi=foodService.findByCtypeIn(2);
    }

    @Test
    public void save() {
        FoodInfo fi=new FoodInfo();
        fi.setFid("10");
        fi.setFname("海鲜");
        fi.setFprice(new BigDecimal(5.21));
        fi.setFdescription("大连特产");
        fi.setFimage("http://sea.jpg");
        fi.setCtype(6);
        FoodInfo result=foodService.save(fi);
        Assert.assertNotNull(result);

    }
}