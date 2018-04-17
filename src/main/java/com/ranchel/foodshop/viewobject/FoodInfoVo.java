package com.ranchel.foodshop.viewobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

/***
 * 商品详情
 */
@Data
public class FoodInfoVo {
    @JsonProperty("id")
    private String fid;

    @JsonProperty("name")
    private String fname;

    @JsonProperty("price")
    private BigDecimal fprice;

    @JsonProperty("description")
    private String fdescription;

    @JsonProperty("image")
    private String fimage;


}
