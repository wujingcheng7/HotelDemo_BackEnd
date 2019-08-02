package com.wujingcheng7.hoteldemo_backend.controller;

import com.wujingcheng7.hoteldemo_backend.config.Result;
import com.wujingcheng7.hoteldemo_backend.service.OrderlistService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/make_an_order")
public class MakeOrderController {
    @Autowired
    private OrderlistService orderlistService;

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {

        //转换日期
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

    @PostMapping("")
    public String MakeOrderList(HttpServletRequest request, Model model, @Param("hotel_room_id")String hotel_room_id, @Param("order_indate")Date order_indate, @Param("order_outdate")Date order_outdate){
        HttpSession session = request.getSession();
        String user_tel = (String)session.getAttribute("user_tel");
        String hotel_id = hotel_room_id.substring(0,6);
        String room_id = hotel_room_id.substring(6);
        Result result = orderlistService.createAnOrder(user_tel,hotel_id,room_id,order_indate,order_outdate);
        if (!result.isSuccess())
            model.addAttribute("createorder","所选时段房间已被预定");
        return "/books_display";
    }
}