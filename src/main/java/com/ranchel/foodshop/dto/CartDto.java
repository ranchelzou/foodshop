package com.ranchel.foodshop.dto;

import lombok.Data;

@Data
public class CartDto {
    /**商品id*/
    private String fid;
    /**数量*/
    private Integer fquantity;

    public CartDto(String fid, Integer fquantity) {
        this.fid = fid;
        this.fquantity = fquantity;
    }
}
