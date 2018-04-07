package com.ranchel.foodshop.dao;

import com.ranchel.foodshop.dateobject.FoodCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    public  void updateTest() {
        FoodCategory fc = new FoodCategory();
        fc.setCid(2);
        fc.setCname("更新了");
        fc.setCtype(3);
        categorydao.save(fc);
    }
}