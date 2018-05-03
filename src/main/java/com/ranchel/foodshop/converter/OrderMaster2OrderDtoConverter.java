package com.ranchel.foodshop.converter;

import com.ranchel.foodshop.dateobject.OrderMaster;
import com.ranchel.foodshop.dto.OrderDto;
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class OrderMaster2OrderDtoConverter {
    public static OrderDto convert(OrderMaster orderMaster){OrderDto orderDto=new OrderDto();
        BeanUtils.copyProperties(orderMaster,orderDto);
        return orderDto;
    }
public static List<OrderDto> convert(List<OrderMaster> orderMasterList){
       return  orderMasterList.stream().map(e->
                convert(e)
        ).collect(Collectors.toList());
}
}
