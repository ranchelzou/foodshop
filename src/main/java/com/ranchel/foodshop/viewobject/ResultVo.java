package com.ranchel.foodshop.viewobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
/**
 * 结果列表
 */

@Data

public class ResultVo <T>{
    /**错误密码*/
    private Integer code;

    /**提示信息*/
    private String msg;
    /**数据*/
    private T Data;
}
