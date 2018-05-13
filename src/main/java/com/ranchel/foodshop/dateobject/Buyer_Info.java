package com.ranchel.foodshop.dateobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Data
@Entity
public class Buyer_Info {
    /**
     * 主键自增
     */
    @Id
    @GeneratedValue
    private Integer id;
    private String username;
    private String password;

}
