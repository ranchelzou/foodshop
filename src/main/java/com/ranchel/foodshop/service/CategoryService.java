package com.ranchel.foodshop.service;

import com.ranchel.foodshop.dao.CategoryDao;
import com.ranchel.foodshop.dateobject.FoodCategory;
import org.hibernate.annotations.ListIndexBase;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.Locale;

/**
 * service CategorySeervice
 */
public interface CategoryService {
    FoodCategory findOne(Integer cid);
    List<FoodCategory> findAll();
    List<FoodCategory> findByCategoryTypeIn(List<Integer> cidList);
}
