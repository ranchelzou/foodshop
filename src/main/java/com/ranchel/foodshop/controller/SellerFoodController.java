package com.ranchel.foodshop.controller;

import com.ranchel.foodshop.dateobject.FoodInfo;
import com.ranchel.foodshop.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

//卖家端商品
@Controller
@RequestMapping ("/seller/food")
public class SellerFoodController {
    @Autowired
    private FoodService foodService;

    @GetMapping("/list")
    //列表，参数：page,size,map
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue ="10") Integer size,
                             Map<String,Object> map){

        PageRequest request=new PageRequest(page-1,size);
        Page<FoodInfo> foodInfoPage=foodService.findAll(request);
        map.put("orderDtoPage",foodInfoPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("food/list",map);
    }

}
