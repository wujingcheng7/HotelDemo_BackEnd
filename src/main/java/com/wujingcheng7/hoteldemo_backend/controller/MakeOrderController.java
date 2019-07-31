package com.wujingcheng7.hoteldemo_backend.controller;

import com.wujingcheng7.hoteldemo_backend.domain.OrderList;
import com.wujingcheng7.hoteldemo_backend.service.OrderlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/make_order")
public class MakeOrderController {
    @Autowired
    private OrderlistService orderlistService;

    public String MakeOrderList(HttpServletRequest request){
        HttpSession session = request.getSession();
        String user_tel = (String)session.getAttribute("user_tel");
        OrderList orderList = new OrderList();
        orderList.setUser_tel(user_tel);
        orderList.setHotel_id((String)request.getAttribute("hotel_id"));
        orderList.setRoom_id((String)request.getAttribute("room_id"));
        orderList.setHotel_room_id((String)request.getAttribute("hotel_room_id"));
//        orderList.
    }
}