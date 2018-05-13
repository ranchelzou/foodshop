package com.ranchel.foodshop.controller;

import com.ranchel.foodshop.dateobject.FoodCategory;
import com.ranchel.foodshop.dateobject.FoodInfo;
import com.ranchel.foodshop.exception.ShopException;
import com.ranchel.foodshop.form.FoodForm;
import com.ranchel.foodshop.service.CategoryService;
import com.ranchel.foodshop.service.FoodService;
import com.ranchel.foodshop.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

//卖家端食品
@Controller
@RequestMapping ("/seller/food")
public class SellerFoodController {
    @Autowired
    private FoodService foodService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    //列表，参数：page,size,map
    public ModelAndView list(@RequestParam(value = "page",defaultValue = "1") Integer page,
                             @RequestParam(value = "size",defaultValue ="10") Integer size,
                             Map<String,Object> map){

        PageRequest request=new PageRequest(page-1,size);
        Page<FoodInfo> foodInfoPage=foodService.findAll(request);
        map.put("foodInfoPage",foodInfoPage);
        map.put("currentPage",page);
        map.put("size",size);
        return new ModelAndView("food/list",map);
    }

    /**
     * 商品上架
     * @param fid
     * @param map
     * @return
     */
    @RequestMapping("/on_sale")
    public ModelAndView onSale(@RequestParam("fid") String fid,
                               Map<String, Object> map) {
        try {
            foodService.onSale(fid);
        } catch (ShopException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/foodshop/seller/food/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/foodshop/seller/food/list");
        return new ModelAndView("common/success", map);
    }

    @RequestMapping("/off_sale")
    public ModelAndView offSale(@RequestParam("fid") String fid,
                               Map<String, Object> map) {
        try {
            foodService.offSale(fid);
        } catch (ShopException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/foodshop/seller/food/list");
            return new ModelAndView("common/error", map);
        }

        map.put("url", "/foodshop/seller/food/list");
        return new ModelAndView("common/success", map);
    }
   @GetMapping("/index")
   public ModelAndView index (@RequestParam(value = "fid",required=false) String fid,
                              Map<String, Object> map) {

        if (!StringUtils.isEmpty(fid)){
            FoodInfo foodInfo=foodService.findOne(fid);
            map.put("foodInfo",foodInfo);
        }
        //查询所有的类目
       List<FoodCategory>categoryList= categoryService.findAll();
        map.put("categoryList",categoryList);
        return new ModelAndView("food/index",map);
   }
/**
     * 保存/更新
     * @param foodForm
     * @param bindingResult
     * @param map
     * @return
     */
   @PostMapping("/save")
    public ModelAndView save(@Valid FoodForm foodForm,
                             BindingResult bindingResult,
                             Map<String, Object> map ){
       if(bindingResult.hasErrors()){
           map.put("msg", bindingResult.getFieldError().getDefaultMessage());
           map.put("url", "/foodshop/seller/food/index");
           return new ModelAndView("common/error", map);
       }
       FoodInfo foodInfo=new FoodInfo();
       try{
           //如果fid为空，说明是新增的
           if(!StringUtils.isEmpty(foodForm.getFid())){
               foodInfo=foodService.findOne(foodForm.getFid());
           }
           else{
               foodForm.setFid(KeyUtil. uKey());
           }
           BeanUtils.copyProperties(foodForm,foodInfo);
           foodService.save(foodInfo);
       }catch (ShopException e){
           map.put("msg", e.getMessage());
           map.put("url", "/foodshop/seller/food/index");
           return new ModelAndView("common/error", map);
       }
       map.put("url", "/foodshop/seller/food/list");
       return new ModelAndView("common/success", map);
   }
}
