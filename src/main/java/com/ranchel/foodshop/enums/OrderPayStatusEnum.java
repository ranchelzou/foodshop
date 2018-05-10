package com.ranchel.foodshop.enums;

import lombok.Getter;

@Getter
public enum OrderPayStatusEnum implements CodeEnum{
   WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;
    private Integer code;
    private String message;

    OrderPayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
