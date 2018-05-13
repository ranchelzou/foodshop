package com.ranchel.foodshop.enums;

import lombok.Data;
import lombok.Getter;

@Getter
public enum ApiCodeEnum{
    USERNOTEXSIT(101, "用户不存在"),
    USEREXSIT(102, "用户存在"),

    USERNAMEISNULL(201,"用户提交数据为空");

    private Integer code;
    private String message;

    ApiCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}