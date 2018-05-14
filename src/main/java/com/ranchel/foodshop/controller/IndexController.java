package com.ranchel.foodshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.servlet.http.HttpSession;
import java.util.Map;

/**/
@Controller
@RequestMapping("/buyer")
public class IndexController {
    @RequestMapping("/index")
    public ModelAndView SellerLogin(HttpSession session) {
        try {
            String username = (String) session.getAttribute("username");
        }catch (Exception e){

        }

        return new ModelAndView("buyer/index");
    }

}

