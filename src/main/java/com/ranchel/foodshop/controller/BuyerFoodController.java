package com.ranchel.foodshop.controller;

import com.ranchel.foodshop.dateobject.FoodInfo;
import com.ranchel.foodshop.service.CategoryService;
import com.ranchel.foodshop.service.FoodService;
import com.ranchel.foodshop.viewobject.FoodInfoVo;
import com.ranchel.foodshop.viewobject.FoodVo;
import com.ranchel.foodshop.viewobject.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
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
        //1.查询所有商品
      List<FoodInfo>foodInfosList= foodService.findWhole();
//
      //2.查询类目（一次性查询）
        List<Integer> categorytypeList=new ArrayList<>();
        //传统方法
for(FoodInfo f:foodInfosList){
    categorytypeList.add(f.getCtype());
}
//精简方法
        foodInfosList.stream().map(e->e.getCtype()).collect(Collectors.toList());
      // List<Integer> categorytypeList=categoryService.findByCtypeIn(categorytypeList);
       //传统方法

        //3.数据拼装
        FoodVo foodVo=new FoodVo();
        ResultVo resultVo=new ResultVo();

        //foodVo.setfoodInfoVoList(Arrays.asList(FoodInfoVo));


        List<FoodInfo> temp = foodService.findByCtypeIn(2);

        foodVo.setFoodInfoVoList(Arrays.asList(temp));
        resultVo.setData(Arrays.asList(foodVo));

        resultVo.setCode(0);
        resultVo.setMsg("成功");
        FoodInfoVo foodInfoVo=new FoodInfoVo();
//        resultVo.setData(foodInfoVo);
      return  resultVo;
        
    }
}
