package com.ranchel.foodshop.dao;

import com.ranchel.foodshop.dateobject.Buyer_Info;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BuyerInfoDao extends JpaRepository<Buyer_Info, Integer> {

    Buyer_Info findByUsernameAndPassword(String username,String password);
    Buyer_Info findByUsername(String username);
}