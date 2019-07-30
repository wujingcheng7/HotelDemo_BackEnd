package com.wujingcheng7.hoteldemo_backend.controller;

import com.wujingcheng7.hoteldemo_backend.domain.Orderlist;
import com.wujingcheng7.hoteldemo_backend.service.OrderlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/books_diaplay")
public class OrderController {
    @Autowired
    OrderlistService orderlistService;

    @GetMapping("")
    public String OrdersDisplay(){
        return "/books_display";
    }

    @PostMapping("/show_myBooks")
    public Model OrdersShow(Model model, @RequestParam("user_tel")String user_tel){


        List<Orderlist> listOfOrderlists = orderlistService.getAllMyOrders(user_tel);

        //TODO:此方法仍需要完善
        return model;
    }

    @PostMapping("/delte_a_book")
    public Model deleteAnOrder(Model model,@RequestParam("order_id")String order_id){

        return model;
    }
}
