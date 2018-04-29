package com.ranchel.foodshop.service;

import com.ranchel.foodshop.dateobject.FoodInfo;
import com.ranchel.foodshop.dto.CartDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FoodService {
    FoodInfo  findOne(String fid);
    Page<FoodInfo> findAll(Pageable pageable);
    List<FoodInfo> findWhole();
    List<FoodInfo> findByCtypeIn(Integer ctype);
    FoodInfo save(FoodInfo fi);
//    //加库存
//    void increateStock(List<CartDto> cartDtoList);
//    //减库存
//    void decreateStock(List<CartDto> cartDtoList);


}
