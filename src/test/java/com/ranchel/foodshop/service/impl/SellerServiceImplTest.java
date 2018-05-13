package com.ranchel.foodshop.service.impl;

import com.ranchel.foodshop.dateobject.SellerInfo;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SellerServiceImplTest {
    private static String openid="admin";
    private static String username="admin";
    private static String password="admin123456";
    @Autowired
   private SellerServiceImpl sellerService;
    @Test
    public void findSellerInfoByOpenid() throws Exception{
        SellerInfo sellerInfo=sellerService.findSellerInfoByOpenid(openid);
        Assert.assertEquals(openid,sellerInfo.getOpenid());
    }
    @Test
    public void findSellerInfoByInfo()throws Exception{
        SellerInfo sellerInfo=sellerService.findSellerInfoByInfo(username,password);
        Assert.assertEquals(username,sellerInfo.getUsername());
        Assert.assertEquals(password,sellerInfo.getPassword());
    }
}