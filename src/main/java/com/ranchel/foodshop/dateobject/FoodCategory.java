package com.ranchel.foodshop.dateobject;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 类目
 * entity 数据库映射成对象
 */

@Entity
public class FoodCategory {
    /**主键自增*/
    @Id
    @GeneratedValue
    private Integer cid;

    private String cname;
    private String ctype;
    //ccreatetime;
    //cupdatetime;


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }



    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCname() {
        return cname;
    }
    @Override
    public String toString() {
        return "food_category{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
