package com.ranchel.foodshop.utils;

import com.ranchel.foodshop.viewobject.ResultVo;

public class ResultVoUtils {
    public  static ResultVo success(Object object){
        ResultVo resultVo=new ResultVo();
        resultVo.setData(object);
        resultVo.setCode(0);
        resultVo.setMsg("成功");
        return resultVo;
    }

    public  static ResultVo success(){
        return success(null);
    }
    public static ResultVo error(Integer code,String msg){
        ResultVo resultVo=new ResultVo();
        resultVo.setCode(code);
        resultVo.setData(msg);
        return resultVo;

    }
}
