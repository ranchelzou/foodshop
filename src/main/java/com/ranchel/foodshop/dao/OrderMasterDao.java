package com.ranchel.foodshop.dao;

import com.ranchel.foodshop.dateobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;



public interface OrderMasterDao extends JpaRepository<OrderMaster, String> {
    Page<OrderMaster> findByBnickname (String bnickname, Pageable pageable);

}
