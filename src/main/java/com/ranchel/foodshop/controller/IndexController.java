package com.ranchel.foodshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**/
@Controller
public class IndexController {
    @RequestMapping("index")
    public String getListaUtentiView(ModelMap map){
        map.put("name", "Spring Boot");
        return "index";
    }
}

