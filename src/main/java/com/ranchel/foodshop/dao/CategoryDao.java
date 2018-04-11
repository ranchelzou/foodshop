package com.ranchel.foodshop.dao;

import com.ranchel.foodshop.dateobject.FoodCategory;
//import springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public   interface CategoryDao extends JpaRepository<FoodCategory,Integer>{
   List<FoodCategory> findByCtypeIn(List<Integer> ctypeList);
}
