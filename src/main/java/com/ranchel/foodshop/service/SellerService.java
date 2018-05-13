package com.ranchel.foodshop.service;

import com.ranchel.foodshop.dateobject.SellerInfo;

/**
 * 卖家端*/
public interface SellerService {
    /**
     * 通过openid 查询卖家消息
     */
    SellerInfo findSellerInfoByOpenid(String openid);
    /**
     * username,password 查询卖家消息
     */
    SellerInfo findSellerInfoByInfo(String username,String password);

}



