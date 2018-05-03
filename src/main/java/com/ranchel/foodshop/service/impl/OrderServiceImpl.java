package com.ranchel.foodshop.service.impl;

import com.ranchel.foodshop.converter.OrderMaster2OrderDtoConverter;
import com.ranchel.foodshop.dao.OrderDetailDao;
import com.ranchel.foodshop.dao.OrderMasterDao;
import com.ranchel.foodshop.dateobject.FoodInfo;
import com.ranchel.foodshop.dateobject.OrderDetail;
import com.ranchel.foodshop.dateobject.OrderMaster;
import com.ranchel.foodshop.dto.CartDto;
import com.ranchel.foodshop.dto.OrderDto;
import com.ranchel.foodshop.enums.OrderPayStatusEnum;
import com.ranchel.foodshop.enums.OrderStatusEnum;
import com.ranchel.foodshop.enums.ResultEnum;
import com.ranchel.foodshop.exception.ShopException;
import com.ranchel.foodshop.service.FoodService;
import com.ranchel.foodshop.service.OrderService;
import com.ranchel.foodshop.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
   private FoodService foodService;
    @Autowired
    private OrderDetailDao orderDetailDao;
    @Autowired
    private OrderMasterDao orderMasterDao;

    @Override
    public OrderDto create(OrderDto orderDto) {
        String oid=KeyUtil.uKey();
        BigDecimal orderAmont=new BigDecimal(0);
        /*第一种转换为CartDo的方法*/
       // List<CartDto> cartDtoLsit=new ArrayList<>();
        //1查询商品（数量，价格）
       for(OrderDetail orderDetail: orderDto.getOrderDetailsList()){
           //先查一条
           FoodInfo foodInfo=foodService.findOne(orderDetail.getFid());
           if(foodInfo==null){
               throw new ShopException(ResultEnum.fOOD_NOT_EXIST);
           }
           //2计算订单总价
           orderAmont=foodInfo.getFprice().
                   multiply(new BigDecimal(orderDetail.getFquantity())).
                   add(orderAmont);
            //订单详情入库
           orderDetail.setDid(KeyUtil.uKey());
           orderDetail.setOid(oid);
           BeanUtils.copyProperties(foodInfo,orderDetail);
           orderDetailDao.save(orderDetail);
//        CartDto cartDto=new CartDto(orderDetail.getFid(),orderDetail.getFquantity());
//           cartDtoLsit.add(cartDto);
       }

        //3写入订单数据库(ordermaster and orderdetail)
        OrderMaster orderMaster=new OrderMaster();
       BeanUtils.copyProperties(orderDto,orderMaster);
        orderMaster.setOid(oid);
        orderMaster.setOamount(orderAmont);
        orderMaster.setOstatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPstatus(OrderPayStatusEnum.WAIT.getCode());
       orderMasterDao.save(orderMaster);

        //扣库存，暂时不用。因为设计里没有只一个属性
//        List<CartDto> cartDtoLsit=orderDto.getOrderDetailsList().stream().map(e->
//                new CartDto(e.getFid(),e.getFquantity()))
//        .collect(Collectors.toList());
//        foodService.decreateStock(cartDtoLsit);
        return orderDto;
    }

    @Override
    public OrderDto findOne(String oid) {

     OrderMaster orderMaster=orderMasterDao.findOne(oid);
     if(orderMaster==null){
         throw new ShopException(ResultEnum.ORDER_NOT_EXIST);

     }
     List<OrderDetail>orderDetailList=orderDetailDao.findByOid(oid);
     if(CollectionUtils.isEmpty(orderDetailList)){
         throw  new ShopException(ResultEnum.ORDERDETAIL_NOT_EXIST);
     }
OrderDto orderDto=new OrderDto();
     BeanUtils.copyProperties(orderMaster,orderDto);
     orderDto.setOrderDetailsList(orderDetailList);
        return orderDto;
    }

    @Override
    public Page<OrderDto> findList(String bnickname, Pageable pageable) {
       Page<OrderMaster > orderMasterPage=orderMasterDao.findByBnickname(bnickname,pageable);
        List<OrderDto>orderDtoList=OrderMaster2OrderDtoConverter.convert(orderMasterPage.getContent());
       Page<OrderDto> orderDtoPage=new PageImpl<OrderDto>(orderDtoList,pageable,orderMasterPage.getTotalElements());


        return orderDtoPage;
    }

    @Override
    public OrderDto cancel(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto finish(OrderDto orderDto) {
        return null;
    }

    @Override
    public OrderDto paid(OrderDto orderDto) {
        return null;
    }
}
