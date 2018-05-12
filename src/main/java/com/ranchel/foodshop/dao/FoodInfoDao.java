package com.ranchel.foodshop.dao;

import com.ranchel.foodshop.dateobject.FoodInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FoodInfoDao extends JpaRepository<FoodInfo,String> {
    List<FoodInfo> findByCtypeIn(Integer ctype);
    List<FoodInfo> findByfstatus(Integer fstatus);
    /**查询所有，是否需要分页*/
    //List<FoodInfo> findWhole();

}
