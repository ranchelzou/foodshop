package com.ranchel.foodshop.exception;

import com.ranchel.foodshop.enums.ResultEnum;

public class ShopException extends RuntimeException{
    private Integer code;
   public ShopException(ResultEnum resultEnum){
       super(resultEnum.getMessage());
       this.code=resultEnum.getCode();
   }

}
