package com.ranchel.foodshop.form;

import lombok.Data;

@Data
public class CategoryForm {

    private Integer cid;

    /** 类目名字. */
    private String cname;

    /** 类目编号. */
    private Integer ctype;
}
