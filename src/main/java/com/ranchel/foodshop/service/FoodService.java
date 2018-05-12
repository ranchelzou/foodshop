package com.ranchel.foodshop.service;

import com.ranchel.foodshop.dateobject.FoodInfo;
import com.ranchel.foodshop.dto.CartDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface FoodService {
    FoodInfo  findOne(String fid);
    //查询所有在架商品
    List<FoodInfo> findUpAll();
    Page<FoodInfo> findAll(Pageable pageable);
    List<FoodInfo> findByCtypeIn(Integer ctype);
    FoodInfo save(FoodInfo fi);
    //List<FoodInfo> findWhole();
//    //加库存
//    void increateStock(List<CartDto> cartDtoList);
//    //减库存
//    void decreateStock(List<CartDto> cartDtoList);

    //上架
    FoodInfo onSale(String fid);
    //下架
    FoodInfo offSale(String fid);


}
