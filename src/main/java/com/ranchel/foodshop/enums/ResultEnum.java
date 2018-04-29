package com.ranchel.foodshop.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    fOOD_NOT_EXIST(10,"商品不存在"),
    FOOD_STOCK_ERROR(11,"商品库存不足"),
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
