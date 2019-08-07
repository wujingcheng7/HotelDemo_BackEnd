package com.wujingcheng7.hoteldemo_backend.controller.front;

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

    //用户当前订单
    @GetMapping("/now")
    public String NowOrdersDisplay(Model model, HttpServletRequest request){
        HttpSession session = request.getSession();
        String user_tel = (String)session.getAttribute("user_tel");
        List<OrderList> listOfOrderLists = orderlistService.getNowOrderListsByUserTel(user_tel);
        model.addAttribute("listOfOrderLists",listOfOrderLists);
        return "/cancel_order";
    }
    //用户所有订单
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

    @PostMapping("/cancel_a_book")
    public String cancelAnOrder(Model model,HttpServletRequest request,@RequestParam("order_id")int order_id){
        boolean isSuccess = orderlistService.cancelAnOrder(order_id)==1;
        if(!isSuccess)
            model.addAttribute("cancelorder","不能取消已进行的订单");
        else
            model.addAttribute("cancelorder","订单取消成功");
        return OrdersDisplay(model,request);
    }

}
