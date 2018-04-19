package com.ranchel.foodshop.viewobject;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
/**
 * 商品（包含类目）
 * 类型
 */
import java.util.List;

@Data
public class FoodVo {
    @JsonProperty("name")
    private String cname;
    @JsonProperty("type")
    private Integer ctype;

    @JsonProperty("foods")
    private List<FoodInfoVo> foodInfoVoList;
}
