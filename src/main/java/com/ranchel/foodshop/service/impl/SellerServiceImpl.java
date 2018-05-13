package com.ranchel.foodshop.service.impl;

import com.ranchel.foodshop.dao.SellerInfoDao;
import com.ranchel.foodshop.dateobject.SellerInfo;
import com.ranchel.foodshop.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl implements SellerService {
    @Autowired
    private SellerInfoDao sellerInfoDao;

    @Override
    public SellerInfo findSellerInfoByOpenid(String openid) {
        return sellerInfoDao.findByOpenid(openid);
    }

    @Override
    public SellerInfo findSellerInfoByInfo(String username, String password) {
        return sellerInfoDao.findByUsernameAndPassword(username,password);
    }
}
