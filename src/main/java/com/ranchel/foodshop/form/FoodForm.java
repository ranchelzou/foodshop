package com.ranchel.foodshop.form;

import com.ranchel.foodshop.enums.FoodStatusEnum;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FoodForm {

    private String fid;
    /**名字*/
    private String fname;
    /** 价格*/
    private BigDecimal fprice;
    /** 简单描述*/
    private  String fdescription;
    /** 图片连接地址*/
    private String fimage;
    /** 类目编号*/
    private  Integer ctype;
}
