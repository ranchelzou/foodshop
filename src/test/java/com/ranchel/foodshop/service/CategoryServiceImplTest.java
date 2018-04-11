package com.ranchel.foodshop.service;

import com.ranchel.foodshop.dateobject.FoodCategory;
import com.ranchel.foodshop.service.impl.CategoryServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryServiceImplTest {
@Autowired
private CategoryServiceImpl categoryService;
    @Test
    public void findOne() {
        FoodCategory fc=categoryService.findOne(1);
        Assert.assertEquals(new Integer(1),fc.getCid());

    }

    @Test
    public void findAll() {
        List<FoodCategory>fcList=categoryService.findAll();
        Assert.assertNotEquals(0,fcList.size());
    }

    @Test
    public void findByCtypeIn() {
        List<FoodCategory>fcList=categoryService.findByCtypeIn(Arrays.asList(1,2,3,4,5));
        Assert.assertNotEquals(0,fcList.size());
    }

    @Test
    public void save() {
        FoodCategory fc=new FoodCategory("i love you",52);
   FoodCategory result=categoryService.save(fc);
   Assert.assertNotNull(result);
    }
}