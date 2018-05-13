package com.ranchel.foodshop.dao;

import com.ranchel.foodshop.dateobject.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerInfoDao extends JpaRepository<SellerInfo, String> {
    SellerInfo findByOpenid(String openid);
    SellerInfo findByUsernameAndPassword(String username,String password);
}

