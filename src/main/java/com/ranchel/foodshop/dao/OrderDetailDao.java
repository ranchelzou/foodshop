package com.ranchel.foodshop.dao;

import com.ranchel.foodshop.dateobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {
    List<OrderDetail> findByOid (String oid);
}
