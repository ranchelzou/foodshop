package com.ranchel.foodshop.controller;

import com.ranchel.foodshop.dateobject.FoodCategory;
import com.ranchel.foodshop.exception.ShopException;
import com.ranchel.foodshop.form.CategoryForm;
import com.ranchel.foodshop.service.CategoryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/***
 * 卖家类目
 */
@Controller
@RequestMapping("/seller/category")
public class SellerCategoryController {

    @Autowired
    private CategoryService categoryService;

    /**
     * 类目列表
     *
     * @param map
     * @return
     */
    @GetMapping("/list")
    public ModelAndView list(Map<String, Object> map) {
        List<FoodCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("category/list", map);
    }

    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "cid", required = false) Integer cid,
                              Map<String, Object> map) {
        if (cid!= null) {
            FoodCategory foodCategory = categoryService.findOne(cid);
            map.put("category", foodCategory);
        }
        return new ModelAndView("category/index", map);
    }

    /**
     * 保存/更新
     * @param categoryForm
     * @param bindingResult
     * @param map
     * @return
     */
    @PostMapping("/save")
    public ModelAndView save(@Valid CategoryForm categoryForm,
                             BindingResult bindingResult,
                             Map<String, Object> map) {
        if (bindingResult.hasErrors()) {
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/foodshop/seller/category/index");
            return new ModelAndView("common/error", map);
        }
        FoodCategory foodCategory = new FoodCategory();
        try {
            if (categoryForm.getCid() != null) {
                foodCategory = categoryService.findOne(categoryForm.getCid());
            }
            BeanUtils.copyProperties(categoryForm, foodCategory);
            categoryService.save(foodCategory);
        } catch (ShopException e) {
            map.put("msg", e.getMessage());
            map.put("url", "/foodshop/seller/category/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/foodshop/seller/category/list");
        return new ModelAndView("common/success", map);
    }
}
