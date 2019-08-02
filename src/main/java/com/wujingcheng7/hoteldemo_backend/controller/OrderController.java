package com.wujingcheng7.hoteldemo_backend.controller;

import com.wujingcheng7.hoteldemo_backend.domain.OrderList;
import com.wujingcheng7.hoteldemo_backend.service.OrderlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

//此类用于控制订单管理页面，不用于创建订单
@Controller
@RequestMapping("/books_display")
public class OrderController {
    @Autowired
    private OrderlistService orderlistService;

    @GetMapping("")
    public String OrdersDisplay(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        String user_tel = (String)session.getAttribute("user_tel");
        List<OrderList> listOfOrderLists = orderlistService.getAllMyOrders(user_tel);
        model.addAttribute("listOfOrderLists",listOfOrderLists);
        return "/books_display";
    }


    @PostMapping("/delete_a_book")
    public String deleteAnOrder(Model model,HttpServletRequest request,@RequestParam("order_id")int order_id){

        orderlistService.deleteAnOrder(order_id);
        return OrdersDisplay(model,request);
    }
}
