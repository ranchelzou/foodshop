package com.ranchel.foodshop.utils;

import com.ranchel.foodshop.enums.CodeEnum;

public class EnumUtils {
    public static <T extends CodeEnum> T getByCode(Integer code, Class<T> enumclass){
        for(T t:enumclass.getEnumConstants()){
            if(code.equals(t.getCode())){
            return t;
             }
        }
        return null;
    }
}
