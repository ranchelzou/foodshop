package com.ranchel.foodshop.dateobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
@Entity
@DynamicUpdate
@Data
public class FoodInfo {

    @Id
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
