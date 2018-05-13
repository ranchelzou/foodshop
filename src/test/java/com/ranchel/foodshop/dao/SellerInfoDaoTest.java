package com.ranchel.foodshop.dao;

import com.ranchel.foodshop.dateobject.SellerInfo;
import com.ranchel.foodshop.utils.KeyUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SellerInfoDaoTest {
    @Autowired
    private SellerInfoDao sellerInfoDao;
    @Test
    public void save(){
        SellerInfo sellerInfo=new SellerInfo();
        sellerInfo.setSellerid(KeyUtil.uKey());
        sellerInfo.setUsername("admin");
        sellerInfo.setPassword("admin123456");
        sellerInfo.setOpenid("admin");
        SellerInfo result=sellerInfoDao.save(sellerInfo);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByOpenid() throws Exception {
        SellerInfo result = sellerInfoDao.findByOpenid("admin");
        Assert.assertEquals("admin", result.getOpenid());
    }
    @Test
    public void findByInfo() throws Exception{
        SellerInfo result = sellerInfoDao.findByUsernameAndPassword("admin","admin123456");
        Assert.assertEquals("admin",result.getUsername());
        Assert.assertEquals("admin123456",result.getPassword());

    }
}