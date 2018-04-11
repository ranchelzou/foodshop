package com.ranchel.foodshop.service.impl;

import com.ranchel.foodshop.dao.CategoryDao;
import com.ranchel.foodshop.dateobject.FoodCategory;
import com.ranchel.foodshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDao cd;
    @Override
    public FoodCategory findOne(Integer cid) {
        return cd.findOne(cid);
    }

    @Override
    public List<FoodCategory> findAll() {
        return cd.findAll();
    }

    @Override
    public List<FoodCategory> findByCtypeIn(List<Integer> ctypeList) {
        return cd.findByCtypeIn(ctypeList);
    }

    @Override
    public FoodCategory save(FoodCategory fc) {
        return cd.save(fc);
    }
}
