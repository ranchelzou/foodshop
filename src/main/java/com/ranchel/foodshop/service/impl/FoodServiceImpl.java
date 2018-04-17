package com.ranchel.foodshop.service.impl;

import com.ranchel.foodshop.dao.FoodInfoDao;
import com.ranchel.foodshop.dateobject.FoodInfo;
import com.ranchel.foodshop.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodInfoDao fiDao;

    @Override
    public  FoodInfo findOne(String fid) {
        return fiDao.findOne(fid);
    }

    @Override
    public Page<FoodInfo> findAll(Pageable pageable) {
        return fiDao.findAll(pageable);
    }

   @Override
    public List<FoodInfo> findWhole() { return fiDao.findAll(); }

    @Override
    public List<FoodInfo> findByCtypeIn(Integer ctype) {
        return fiDao.findByCtypeIn(ctype);
    }

    @Override
    public FoodInfo save(FoodInfo fi) {
        return fiDao.save(fi);
    }
}
