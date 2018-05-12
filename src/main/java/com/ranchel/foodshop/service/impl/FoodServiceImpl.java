package com.ranchel.foodshop.service.impl;

import com.ranchel.foodshop.dao.FoodInfoDao;
import com.ranchel.foodshop.dateobject.FoodInfo;
import com.ranchel.foodshop.enums.FoodStatusEnum;
import com.ranchel.foodshop.enums.ResultEnum;
import com.ranchel.foodshop.exception.ShopException;
import com.ranchel.foodshop.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodInfoDao fiDao;

    @Override
    public FoodInfo findOne(String fid) {
        return fiDao.findOne(fid);
    }

    @Override
    public List<FoodInfo> findUpAll() {
        return fiDao.findByfstatus(FoodStatusEnum.UP.getCode());
    }

    @Override
    public Page<FoodInfo> findAll(Pageable pageable) {
        return fiDao.findAll(pageable);
    }

//    @Override
//    public List<FoodInfo> findWhole() {
//        return fiDao.findAll();
//    }

    @Override
    public List<FoodInfo> findByCtypeIn(Integer ctype) {
        return fiDao.findByCtypeIn(ctype);
    }

    @Override
    public FoodInfo save(FoodInfo fi) {
        return fiDao.save(fi);
    }

//    @Override
// @Transactional
//    public void increateStock(List<CartDto> cartDtoList) {
//    for(
//    CartDto cartDto:cartDtoList)
//
//    {
//        FoodInfo foodInfo = fiDao.findOne(cartDto.getFid());
//        if (foodInfo == null) {
//            throw new ShopException(ResultEnum.fOOD_NOT_EXIST);
//        }
//        Integer result = foodInfo.getFStock() + cartDto.getFquantity();
//        foodInfo.setFStock(result);
//        fiDao.save(foodInfo);
//    }
//}
//    @Override
//    @Transactional
//    //此备注是指要么全部成功，要么全部失败
//    public void decreateStock(List<CartDto> cartDtoList) {
//        for(CartDto cartDto:cartDtoList){
//            FoodInfo foodInfo=fiDao.findOne(cartDto.getFid());
//            if(foodInfo==null){
//                throw new ShopException(ResultEnum.fOOD_NOT_EXIST);
//                }
//              Integer result=foodInfo.getFStock()-cartDto.getFquantity();
//                if(result<0){
//                    throw new ShopException(ResultEnum.FOOD_STOCK_ERROR);
//                }
//                foodInfo.setFStock(result);
//                fiDao.save(foodInfo);
//            }
//
//        }
//
//
//    }


    @Override
    public FoodInfo onSale(String fid) {
        FoodInfo foodInfo = fiDao.findOne(fid);
        if (foodInfo == null) {
            throw new ShopException(ResultEnum.fOOD_NOT_EXIST);
        }
        if (foodInfo.getFoodStatusEnum() == FoodStatusEnum.UP) {
            throw new ShopException(ResultEnum.FOOD_STATUS_ERROR);
        }

        //更新
        foodInfo.setFstatus(FoodStatusEnum.UP.getCode());
        return fiDao.save(foodInfo);
    }

    @Override
    public FoodInfo offSale(String fid) {
        FoodInfo foodInfo = fiDao.findOne(fid);
        if (foodInfo == null) {
            throw new ShopException(ResultEnum.fOOD_NOT_EXIST);
        }
        if (foodInfo.getFoodStatusEnum() == FoodStatusEnum.DOWN) {
            throw new ShopException(ResultEnum.FOOD_STATUS_ERROR);
        }

        //更新
        foodInfo.setFstatus(FoodStatusEnum.DOWN.getCode());
        return fiDao.save(foodInfo);
    }
}
