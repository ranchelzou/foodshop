package com.ranchel.foodshop.utils;

import lombok.Getter;

import java.util.Random;

//数据库

public class KeyUtil {
    /**生成唯一的主键
     * 格式：时间+随机数*/
    public static synchronized String uKey(){
        Random random=new Random();
        //时间精确到毫秒，但是也有可能多线程并发，有可能重复 。所以添加一个sysc
        System.currentTimeMillis();
        Integer number=random.nextInt(900000)+100000;
        return System.currentTimeMillis()+String.valueOf(number);
    }

}
