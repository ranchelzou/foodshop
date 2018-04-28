package com.ranchel.foodshop.dateobject;

import com.ranchel.foodshop.enums.OrderStatusEnum;
import com.ranchel.foodshop.enums.PayStatusEnum;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@DynamicUpdate
public class OrderMaster {
    @Id
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
    private Integer ostatus=OrderStatusEnum.NEW.getCode();
    /**0默认为支付*/
    private Integer pstatus=PayStatusEnum.WAIT.getCode();
    /**创建时间*/
    private Date ocreatetime;
    private Date oupdatetime;

}
