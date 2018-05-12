package com.ranchel.foodshop.enums;


import lombok.Getter;

/**
 * 商品状态
 */
@Getter
public enum FoodStatusEnum implements CodeEnum {
    UP(0, "在架"),
    DOWN(1, "下架")
    ;
    private Integer code;

    private String message;

   FoodStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
