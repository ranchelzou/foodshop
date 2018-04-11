package com.ranchel.foodshop.service;

import com.ranchel.foodshop.dateobject.FoodCategory;
import java.util.List;

/**
 * service CategoryService
 */
public interface CategoryService {
    /*查询一个
    *
     */
    FoodCategory findOne(Integer cid);
    /*查询所有
     *List
     */
    List<FoodCategory> findAll();
    List<FoodCategory> findByCtypeIn(List<Integer> ctypeList);

    FoodCategory save(FoodCategory fc);
}
