package com.ranchel.foodshop.service;

import com.ranchel.foodshop.dateobject.FoodInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FoodService {
    FoodInfo  findOne(String fid);
    Page<FoodInfo> findAll(Pageable pageable);
    List<FoodInfo> findWhole();
    List<FoodInfo> findByCtypeIn(Integer ctype);
    FoodInfo save(FoodInfo fi);

}
