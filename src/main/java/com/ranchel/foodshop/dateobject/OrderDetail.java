package com.ranchel.foodshop.dateobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class OrderDetail {
    @Id
    private String did;
    private String oid;
    private String fid;
    private String fname;
    private String fprice;
    /**商品数量*/
    private String fquantity;
    private String fimage;
    //private Date dcreatetime;


}
