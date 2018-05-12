package com.ranchel.foodshop.controller;

import com.ranchel.foodshop.converter.OrderForm2OrderDtoConverter;
import com.ranchel.foodshop.dto.OrderDto;
import com.ranchel.foodshop.enums.ResultEnum;
import com.ranchel.foodshop.exception.ShopException;
import com.ranchel.foodshop.form.OrderForm;
import com.ranchel.foodshop.service.BuyerService;
import com.ranchel.foodshop.service.OrderService;
import com.ranchel.foodshop.utils.ResultVoUtils;
import com.ranchel.foodshop.viewobject.ResultVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;

   // 创建订单
   @PostMapping("/create")
    public ResultVo<Map<String,String>> create(@Valid OrderForm orderForm,
                                               BindingResult bindingResult){
        //表单校验有没有错误
        if(bindingResult.hasErrors()){
            log.error("[创建订单] 参数不正确，orderForm{}",orderForm);
            throw new ShopException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDto orderDto=OrderForm2OrderDtoConverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDto.getOrderDetailsList())){
            log.error("[创建订单] 购物车不为空");
            throw new ShopException(ResultEnum.CART_EMPTY);
        }
                OrderDto createResult=orderService.create(orderDto);
        Map<String,String> map=new HashMap<>();
        map.put("orderid",createResult.getOid());
        return ResultVoUtils.success(map);
    }

    //订单列表
    @GetMapping("/list")
    public ResultVo<List<OrderDto>> list(@RequestParam("openid") String bnickname,
                                         @RequestParam(value="page",defaultValue ="0") Integer page,
                                         @RequestParam(value = "size",defaultValue ="10" ) Integer size){
        if(StringUtils.isEmpty(bnickname)){
            log.error("[查询订单列表] opinid 为空");
            throw new ShopException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request=new PageRequest(page,size);
       Page<OrderDto> orderDtoPage=orderService.findList(bnickname,request);
       return ResultVoUtils.success(orderDtoPage.getContent());
    }
    //订单详情
  @GetMapping("/detail")
    public ResultVo<OrderDto> detail(@RequestParam("openid") String bnickname,
                                     @RequestParam("oid") String oid){
      OrderDto orderDto=buyerService.findOrderOne(bnickname, oid);
        return ResultVoUtils.success(orderDto);
  }
    //取消订单
    @PostMapping ("/cancel")
    public ResultVo cancel(@RequestParam("openid") String bnickname,
                           @RequestParam("oid") String oid){
       buyerService.cancelOrder(bnickname, oid);
       return ResultVoUtils.success();

    }

}
