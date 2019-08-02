package com.wujingcheng7.hoteldemo_backend.controller;

import com.wujingcheng7.hoteldemo_backend.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 这个控制器用于接收酒店后台管理人员的请求，还未做完
 */
@Controller
@RequestMapping("/hotel_admin")
public class HotelAdminController {
    @Autowired
    HotelService hotelService;

    @GetMapping("")
    public String getHtml(){
        return "/hotel_admin";
    }

    //酒店后台更新订单
    @PostMapping("/update_invoice")
    public Model update_invoice(HttpServletRequest request,Model model){
        HttpSession session = request.getSession();
        String hotel_id = (String) session.getAttribute("hotel_id");
        String hotel_admin_id = (String) session.getAttribute("hotel_admin_id");
        String hotel_admin_pwd = (String) session.getAttribute("hotel_admin_pwd");


        return model;
    }

}
