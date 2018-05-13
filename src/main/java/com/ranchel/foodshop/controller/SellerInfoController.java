package com.ranchel.foodshop.controller;

import com.ranchel.foodshop.dateobject.SellerInfo;
import com.ranchel.foodshop.dto.OrderDto;
import com.ranchel.foodshop.form.SellerInfoForm;
import com.ranchel.foodshop.service.SellerService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("/seller/owner")
public class SellerInfoController {

    protected static final Logger logger = LoggerFactory.getLogger(SellerInfoController.class);
    @Autowired
    private SellerService sellerService;
    @RequestMapping("/login")
    public ModelAndView SellerLogin() {
        return new ModelAndView("owner/login");
    }

    @PostMapping("/checkin")
    public ModelAndView SellerCheckin(
                        @Valid SellerInfoForm sellerInfoForm
//                        BindingResult bindingResult,
//                        Map<String, Object> map
    ) {
        //验证逻辑
        SellerInfo sellerInfo = sellerService.findSellerInfoByInfo(sellerInfoForm.getUsername(),sellerInfoForm.getPassword());

        //不通过
        if(sellerInfo==null){
            return new ModelAndView("redirect:/seller/owner/login");
        }else {
            System.out.println(sellerInfo.getUsername());
            System.out.println(sellerInfo.getPassword());
            logger.info("登录成功",sellerInfo.getUsername()+" /  "+sellerInfo.getPassword());
            return new ModelAndView("redirect:/seller/order/list");
        }

    }
}
