package com.ranchel.foodshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import java.util.Map;

/**/
@Controller
@RequestMapping("/buyer")
public class IndexController {
    @RequestMapping("/index")
    public ModelAndView SellerLogin() {
        return new ModelAndView("buyer/index");
    }
    //CESHI 
}

