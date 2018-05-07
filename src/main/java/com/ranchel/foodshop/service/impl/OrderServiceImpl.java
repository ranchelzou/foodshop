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
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
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
        orderDto.setOid(oid);
        BeanUtils.copyProperties(orderDto,orderMaster);
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
    //卖家端查询订单列表
    @Override
    public Page<OrderDto> findList( Pageable pageable){
       Page<OrderMaster> orderMasterPage=orderMasterDao.findAll(pageable);
        List<OrderDto>orderDtoList=OrderMaster2OrderDtoConverter.convert(orderMasterPage.getContent());

        return new PageImpl<>(orderDtoList,pageable,orderMasterPage.getTotalElements());


    }
    @Override
    @Transactional
    public OrderDto cancel(OrderDto orderDto) {
        OrderMaster orderMaster=new OrderMaster();

        //判断订单状态
        if (!orderDto.getOstatus().equals(OrderStatusEnum.NEW.getCode())){
            log.error("[取消订单]订单状态不正确，orderId={},orderStatus={}",orderDto.getOid(),orderDto.getOstatus());
            throw new ShopException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //修改订单状态
        orderDto.setOstatus(OrderStatusEnum.CANCEL.getCode());
        BeanUtils.copyProperties(orderDto,orderMaster);
        OrderMaster updateResult=orderMasterDao.save(orderMaster);

        if(updateResult==null){
            log.error("[取消订单] 更新失败，orderMaster={}",orderMaster);
            throw new ShopException(ResultEnum.ORDER_UPADATE_FAIL);
        }
        //返还库存（这个可以暂时不理会）
//        if(CollectionUtils.isEmpty(orderDto.getOrderDetailsList())){
//            log.error("[取消订单] 订单无商品详情，orderDto={}",orderDto);
//            throw new ShopException(ResultEnum.ORDER_DETAIL_EMPTY);
//        }
//        List<CartDto> cartDtoList=orderDto.getOrderDetailsList().stream()
//                .map(e->new CartDto(e.getFid(),e.getFquantity()))
//                .collect(Collectors.toList());
//        foodService.increaseStock(cartDtoList);

        //如果已支付，需要退款
        if(orderDto.getPstatus().equals(OrderPayStatusEnum.SUCCESS.getCode())){
            //TODO
        }
        return orderDto;
    }

    @Override
    public OrderDto finish(OrderDto orderDto) {
        //判断订单状态
        if(!orderDto.getOstatus().equals(OrderStatusEnum.NEW.getCode())){
            log.error("[完结订单]订单状态不正确，orderId={},orderStatus={}",orderDto.getOid(),orderDto.getOstatus());
          throw new ShopException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //修改订单状态
        orderDto.setOstatus(OrderStatusEnum.FINISHEND.getCode());
        OrderMaster orderMaster=new OrderMaster();
        BeanUtils.copyProperties(orderDto,orderMaster);
         OrderMaster updateResult=orderMasterDao.save(orderMaster);
        if(updateResult==null){
            log.error("[完结订单] 更新失败，orderMaster={}",orderMaster);
            throw new ShopException(ResultEnum.ORDER_UPADATE_FAIL);
        }

        return orderDto;
    }

    @Override
    @Transactional
    public OrderDto paid(OrderDto orderDto) {
        //判断订单状态
        if(!orderDto.getOstatus().equals(OrderStatusEnum.NEW.getCode())){
            log.error("[订单支付完成]订单状态不正确，orderId={},orderStatus={}",orderDto.getOid(),orderDto.getOstatus());
            throw new ShopException(ResultEnum.ORDER_STATUS_ERROR);
        }
        //判断支付状态
            if(!orderDto.getPstatus().equals((OrderPayStatusEnum.WAIT.getCode()))){
            log.error("[订单支付完成] 订单支付状态不正确，orderId={},orderStatus={}",orderDto);
            throw new ShopException(ResultEnum.ORDER_PAY_STATUS_ERROR);
            }
        //修改支付状态
        orderDto.setPstatus(OrderPayStatusEnum.SUCCESS.getCode());
        OrderMaster orderMaster=new OrderMaster();
        BeanUtils.copyProperties(orderDto,orderMaster);
        OrderMaster updateResult=orderMasterDao.save(orderMaster);
        if(updateResult==null){
            log.error("[订单支付完成] 更新失败，orderMaster={}",orderMaster);
            throw new ShopException(ResultEnum.ORDER_UPADATE_FAIL);
        }
        return orderDto;
    }
}
