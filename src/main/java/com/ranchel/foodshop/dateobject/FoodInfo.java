package com.ranchel.foodshop.dateobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ranchel.foodshop.enums.FoodStatusEnum;
import com.ranchel.foodshop.utils.EnumUtils;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;
import java.util.Date;

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
    /** 状态, 0正常1下架. */
    private Integer fstatus = FoodStatusEnum.UP.getCode();
    /** 类目编号*/
    private  Integer ctype;
    private Date fcreatetime;
    private Date fupdatetime;

    @JsonIgnore
    public FoodStatusEnum getFoodStatusEnum() {
        return EnumUtils.getByCode(fstatus, FoodStatusEnum.class);
    }




}
