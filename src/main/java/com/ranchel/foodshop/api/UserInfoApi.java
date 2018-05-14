package com.ranchel.foodshop.api;

import com.ranchel.foodshop.dao.BuyerInfoDao;
import com.ranchel.foodshop.dateobject.ApiMessage;
import com.ranchel.foodshop.dateobject.Buyer_Info;
import com.ranchel.foodshop.enums.ApiCodeEnum;
import com.ranchel.foodshop.form.SellerInfoForm;
import org.apache.tomcat.util.http.RequestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/api")
public class UserInfoApi {
    @Autowired
    private BuyerInfoDao buyerInfoDao;
    @RequestMapping("/checkusername")
    @ResponseBody
    public ApiMessage BuyerUsernameCheckin(HttpServletRequest request, HttpServletResponse response) {

        //跨域设置
        common(response);

        ApiMessage apiMessage = new ApiMessage();
        String  username = request.getParameter("username");
        Buyer_Info buyer_info = null;
        try {
            buyer_info = buyerInfoDao.findByUsername(username);
        }catch (NullPointerException e){
            apiMessage.setCode(ApiCodeEnum.USERNOTEXSIT.getCode());
            apiMessage.setMessage(ApiCodeEnum.USERNOTEXSIT.getMessage());
            return apiMessage;
        }
        if(buyer_info!=null){
            apiMessage.setCode(ApiCodeEnum.USEREXSIT.getCode());
            apiMessage.setMessage(ApiCodeEnum.USEREXSIT.getMessage());
        }else {
            apiMessage.setCode(ApiCodeEnum.USERNOTEXSIT.getCode());
            apiMessage.setMessage(ApiCodeEnum.USERNOTEXSIT.getMessage());
        }

        return apiMessage;
    }

    @RequestMapping("/register")
    @ResponseBody
    public ApiMessage BuyerRegister(HttpServletRequest request, HttpServletResponse response) {

        //跨域设置
        common(response);

        ApiMessage apiMessage = new ApiMessage();
        String  username = request.getParameter("username");
        String password=request.getParameter("password");
        System.out.println(username+"/"+password);
        apiMessage.setMessage(ApiCodeEnum.USERNOTEXSIT.getMessage());
        return apiMessage;
    }
    //@RequestMapping("/login")
    @PostMapping("/login")
    @ResponseBody
    public ApiMessage BuyerLogin(@RequestParam(name = "username") String username,
                                 @RequestParam(name = "password") String password,
                                 HttpSession session  ){
//     //跨域设置
//     common(response);
//        @RequestMapping("/checkusername")
//    ApiMessage apiMessage = new ApiMessage();
//    String  username = request.getParameter("username");
//    String password=request.getParameter(s:"password");
        Buyer_Info buyer_info = buyerInfoDao.findByUsernameAndPassword(username, password);
        if(buyer_info==null){

        }

        return null;
 }

    private HttpServletResponse common( HttpServletResponse response){
        //这里填写你允许进行跨域的主机ip
        response.setHeader("Access-Control-Allow-Origin", "*");
        //允许的访问方法
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE, PATCH");
        //Access-Control-Max-Age 用于 CORS 相关配置的缓存
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
        return response;
    }
}
