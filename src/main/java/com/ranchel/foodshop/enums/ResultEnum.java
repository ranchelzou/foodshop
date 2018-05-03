package com.ranchel.foodshop.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    fOOD_NOT_EXIST(1,"商品不存在"),
    FOOD_STOCK_ERROR(2,"商品库存不足"),
    ORDER_NOT_EXIST(3,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(4,"订单详情不存在"),
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
