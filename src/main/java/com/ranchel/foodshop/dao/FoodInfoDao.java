package com.ranchel.foodshop.dao;

import com.ranchel.foodshop.dateobject.FoodInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FoodInfoDao extends JpaRepository<FoodInfo,String> {
    List<FoodInfo> findByCtypeIn(Integer ctype);
//    List<FoodInfo> findWhole();

}
