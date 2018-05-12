package com.ranchel.foodshop.dateobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 类目
 * entity 数据库映射成对象
 */

@Entity
@DynamicUpdate
@Data

public class FoodCategory {
    /**
     * 主键自增
     */
    @Id
    @GeneratedValue
    private Integer cid;

    private String cname;
    private Integer ctype;

    private Date ccreatetime;
    private Date cupdatetime;

    public FoodCategory() {
    }

    public FoodCategory(String cname, Integer ctype) {
        this.cname = cname;
        this.ctype = ctype;
    }
}
