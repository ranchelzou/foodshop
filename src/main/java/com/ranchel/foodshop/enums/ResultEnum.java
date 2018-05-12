package com.ranchel.foodshop.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(0,"成功"),
    fOOD_NOT_EXIST(1,"食品不存在"),
    FOOD_STATUS_ERROR(11,"食品状态不正确"),
    FOOD_STOCK_ERROR(2,"食品库存不足"),
    ORDER_NOT_EXIST(3,"订单不存在"),
    ORDERDETAIL_NOT_EXIST(4,"订单详情不存在"),
    ORDER_STATUS_ERROR(5,"订单状态不正确"),
    ORDER_UPADATE_FAIL(6,"订单更新失败"),
    ORDER_DETAIL_EMPTY(7,"订单详情是空"),
    ORDER_PAY_STATUS_ERROR(8,"订单支付状态不正确"),
    PARAM_ERROR(20,"参数不正确"),
    CART_EMPTY(30,"购物车不能为空"),
    ORDER_OWNER_ERROE(40,"该订单不属于当前用户"),
    ORDER_CANCEL_SUCCESS(22,"订单取消成功"),
    ORDER_FINISH_SUCCESS(22,"订单完结"),
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
