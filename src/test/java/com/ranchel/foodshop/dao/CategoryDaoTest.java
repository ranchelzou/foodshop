package com.ranchel.foodshop.dao;

import com.ranchel.foodshop.dateobject.FoodCategory;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import java.util.Arrays;
import java.util.List;

/**
 * @RunWith is annotation -single model to test
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CategoryDaoTest {
    @Autowired
    private CategoryDao categorydao;
    @Test
    public void findOneTest(){
       //FoodCategory fc= categorydao.findById(id:1);
        FoodCategory foodCategory = categorydao.findOne(1);
       System.out.println(foodCategory.toString());

    }
    @Test
    public  void saveTest(){
        FoodCategory fc=new FoodCategory();
        fc.setCname("fruit");
       fc.setCtype(3);
        categorydao.save(fc);

}
    @Test
    @Transactional
    public  void updateTest() {
        FoodCategory fc = new FoodCategory("我的最爱",6);
        FoodCategory result=categorydao.save(fc);
        Assert.assertNotNull(result);
    }
    @Test
   public  void findByCtypeInTest(){
        List<Integer> list= Arrays.asList(2,4,5);
       List<FoodCategory> result=categorydao.findByCtypeIn(list);
        Assert.assertNotEquals(0,result.size());

    }
}