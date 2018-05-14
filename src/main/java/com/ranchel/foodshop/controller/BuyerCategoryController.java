package com.ranchel.foodshop.controller;

import com.ranchel.foodshop.dateobject.FoodCategory;
import com.ranchel.foodshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/buyer/index")
public class BuyerCategoryController {
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

    }
