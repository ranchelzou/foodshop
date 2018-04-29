package com.ranchel.foodshop.dto;

import com.ranchel.foodshop.dateobject.OrderDetail;
import lombok.Data;

import javax.persistence.Transient;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderDto {
    private String oid;
    /**买家名字*/
    private String bname;
    /**买家电话*/
    private String bphone;
    /**买家地址*/
    private String baddress;
    /**买家账号*/
    private String bnickname;
    /**数量*/
    private BigDecimal oamount;
    /**订单状态0新下单*/
    private Integer ostatus;
    /**0默认为支付*/
    private Integer pstatus;
    /**创建时间*/
    private Date ocreatetime;
    /**更新时间*/
    private Date oupdatetime;
    @Transient
  List<OrderDetail> orderDetailsList;
}
