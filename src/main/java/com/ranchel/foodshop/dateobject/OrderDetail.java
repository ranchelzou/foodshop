package com.ranchel.foodshop.dateobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
public class OrderDetail {
    @Id
    private String did;
    private String oid;
    private String fid;
    private String fname;
    private BigDecimal fprice;
    /**商品数量*/
    private Integer fquantity;
    private String fimage;
    //private Date dcreatetime;


}
