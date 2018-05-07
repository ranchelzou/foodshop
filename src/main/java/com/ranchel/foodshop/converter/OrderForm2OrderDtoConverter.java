package com.ranchel.foodshop.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.ranchel.foodshop.dateobject.OrderDetail;
import com.ranchel.foodshop.dto.OrderDto;
import com.ranchel.foodshop.enums.ResultEnum;
import com.ranchel.foodshop.exception.ShopException;
import com.ranchel.foodshop.form.OrderForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
@Slf4j
public class OrderForm2OrderDtoConverter {
    public static OrderDto convert(OrderForm orderForm){
        Gson gson=new Gson();
        OrderDto orderDto=new OrderDto();
        orderDto.setBname(orderForm.getName());
        orderDto.setBphone(orderForm.getPhone());
        orderDto.setBaddress(orderForm.getAddress());
        orderDto.setBnickname(orderForm.getOpenid());
        List<OrderDetail> orderDetailList=new ArrayList<>();
        try {
            //json转换成list
            orderDetailList=gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {
                    }.getType());
        }catch (Exception e){
            log.error("[对象转换]错误，string={}",orderForm.getItems());
            throw new ShopException(ResultEnum.PARAM_ERROR);
        }
        orderDto.setOrderDetailsList(orderDetailList);
       // BeanUtils.copyProperties();
return orderDto;
    }
}
