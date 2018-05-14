package com.ranchel.foodshop.controller;

import com.ranchel.foodshop.viewobject.FoodInfoVo;
import com.ranchel.foodshop.viewobject.FoodVo;
import com.ranchel.foodshop.viewobject.ResultVo;
import com.ranchel.foodshop.dateobject.FoodCategory;
import com.ranchel.foodshop.dateobject.FoodInfo;
import com.ranchel.foodshop.service.CategoryService;
import com.ranchel.foodshop.service.FoodService;
import com.ranchel.foodshop.utils.ResultVoUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**/
@RestController
@RequestMapping("/buyer/food")
 public class BuyerFoodController {
    @Autowired
    private FoodService foodService;
   @Autowired
   private CategoryService categoryService;


    @GetMapping("/list")
    public ResultVo list(){

//        //1.查询所有商品
      List<FoodInfo>foodInfosList= foodService.findUpAll();

      //2.查询类目（一次性查询）
    //精简方法
        List<Integer> categorytypeList =foodInfosList.stream()
                .map(e->e.getCtype())
                .collect(Collectors.toList());
      List<FoodCategory> foodCategoriesList= categoryService.findByCtypeIn(categorytypeList);

     //3.数据拼装
        List<FoodVo> foodVoList=new ArrayList<>();
        for(FoodCategory fc:foodCategoriesList){
            FoodVo foodVo=new FoodVo();
            foodVo.setCtype(fc.getCtype());
            foodVo.setCname(fc.getCname());
            List<FoodInfoVo>foodInfoVoList=new ArrayList<>();
            for(FoodInfo f:foodInfosList){
                if(f.getCtype().equals(fc.getCtype())){
                    FoodInfoVo foodInfoVo=new FoodInfoVo();
                    BeanUtils.copyProperties(f,foodInfoVo);
                    foodInfoVoList.add(foodInfoVo);
                }
            }foodVo.setFoodInfoVoList(foodInfoVoList);
            foodVoList.add(foodVo);
        }
        return ResultVoUtils.success(foodVoList);
    }
}
